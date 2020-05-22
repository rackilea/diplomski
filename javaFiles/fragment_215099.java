class Macros(val c: blackbox.Context) {
  import c.universe._

  def persistImpl[A: c.WeakTypeTag, Repr: c.WeakTypeTag](f: c.Tree)(keyPrefix: c.Expr[ActorIdentifier], scalaCache: c.Expr[ScalaCache[Repr]], flags: c.Expr[Flags], ec: c.Expr[ExecutionContext], codec: c.Expr[Codec[A, Repr]]) = {
    commonMacroImpl(keyPrefix,  scalaCache, { keyName =>
      q"""_root_.persistence.sync.caching($keyName)($f)($scalaCache, $flags, $ec, $codec)"""
    })
  }

  private def commonMacroImpl[A: c.WeakTypeTag, Repr: c.WeakTypeTag](keyPrefix: c.Expr[ActorIdentifier], scalaCache: c.Expr[ScalaCache[Repr]], keyNameToCachingCall: (c.TermName) => c.Tree): Tree = {

    val enclosingMethodSymbol = getMethodSymbol()
    val valNameTree = getValName(enclosingMethodSymbol)

    val keyName = createKeyName()
    val scalacacheCall = keyNameToCachingCall(keyName)
    val tree = q"""
          val $keyName = _root_.persistence.KeyStringConverter.createKeyString($keyPrefix, $valNameTree)
          $scalacacheCall
        """
    tree
  }

  /**
    * Get the symbol of the method that encloses the macro,
    * or abort the compilation if we can't find one.
    */
  private def getValSymbol(): c.Symbol = {

    def getValSymbolRecursively(sym: Symbol): Symbol = {
      if (sym == null || sym == NoSymbol || sym.owner == sym)
        c.abort(
          c.enclosingPosition,
          "This persistence block does not appear to be inside a val. " +
            "Memoize blocks must be placed inside vals, so that a cache key can be generated."
        )
      else if (sym.isTerm)
        try {
          val termSym = sym.asInstanceOf[TermSymbol]
          if(termSym.isVal) termSym
          else getValSymbolRecursively(sym.owner)
        } catch {
          case NonFatal(e) => getValSymbolRecursively(sym.owner)
        }
      else
        getValSymbolRecursively(sym.owner)
    }

    getValSymbolRecursively(c.internal.enclosingOwner)
  }

  /**
    * Convert the given method symbol to a tree representing the method name.
    */
  private def getValName(methodSymbol: c.Symbol): c.Tree = {
    val methodName = methodSymbol.asMethod.name.toString
    // return a Tree
    q"$methodName"
  }

  private def createKeyName(): TermName = {
    // We must create a fresh name for any vals that we define, to ensure we don't clash with any user-defined terms.
    // See https://github.com/cb372/scalacache/issues/13
    // (Note that c.freshName("key") does not work as expected.
    // It causes quasiquotes to generate crazy code, resulting in a MatchError.)
    c.freshName(c.universe.TermName("key"))
  }

}