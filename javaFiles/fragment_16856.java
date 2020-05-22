public static ErrorDescription computeWarning(HintContext ctx) {
    Fix fix = JavaFixUtilities.rewriteFix(ctx, "Use notMain instead",
            ctx.getPath(), "test.HintTest.notMain($args)");
    return ErrorDescriptionFactory.forName(ctx, ctx.getPath(), Bundle.
            ERR_MainCallHint(), fix);
}