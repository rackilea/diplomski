import com.sun.tools.javac.code.Symbol.*;   

private void attribClassBody(Env<AttrContext> env, ClassSymbol c) {
    ....

    // Check that a generic class doesn't extend Throwable
    if (!c.type.allparams().isEmpty() && types.isSubtype(c.type, syms.throwableType))
        log.error(tree.extending.pos(), "generic.throwable");