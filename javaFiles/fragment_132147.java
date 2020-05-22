for (tree <- unit.body) {
  tree match {
    case tree@DefDef(mods, name, tparams, vparamss, tpt, rhs)
      if isJavaAndNotAccessor(mods, rhs.symbol) =>
      printJava(rhs, "DefDef")

    case tree@ValDef(mods, name, tpt, rhs) =>
      if (isJavaAndNotAccessor(mods, tpt.symbol))
        printJava(tpt, "ValDef")
      tpt.tpe.typeArgs.foreach(t => findAllJavaTypes(t.baseTypeSeq.toList).foreach(sym => printJavaCustom(sym, posWithFallback(sym.pos, tree.pos), "TpeArg")))

    case tree@Template(parents, self, body) =>
      parents.foreach(p => findAllJavaTypes(p.tpe.baseTypeSeq.toList).foreach(sym => printJavaCustom(sym, posWithFallback(p.pos, tree.pos), "TpeDef")))

    case tree@Select(qual, name) =>
      if (isJavaAndNotJLObjectInit(tree.symbol) && (tree.symbol.isMethod || tree.symbol.isValue || tree.symbol.isStaticMember))
        printJava(tree, "Select")

    case _ =>
  }
}

private def findAllJavaTypes(types: List[Type]): List[Symbol] = {
  def find0(types: List[Type], result: List[Type]): List[Type] =
    if (types == List())
      result
    else
      find0(types.flatMap(_.typeArgs), types.filter(tpe => isJavaAndNotJLObject(tpe.typeSymbol)) ::: result)

  find0(types, List()).distinct.map(_.typeSymbol)
}