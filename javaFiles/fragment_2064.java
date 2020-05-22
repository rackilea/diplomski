@Override
public boolean bodyCall( final Node[] args, final int length, final RuleContext context )
{
    checkArgs(length, context);
    final Node n1 = getArg(0, args, context);
    final Node n2 = getArg(1, args, context);

    if (n1.isLiteral() && n2.isLiteral()) {
        final Node max = Util.compareTypedLiterals(n1, n2) < 0 ? n2 : n1;
        return context.getEnv().bind(args[2], max);
    }
    return false;
}