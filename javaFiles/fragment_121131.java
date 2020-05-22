public static void handleTokens(ParseTree ctx)
        List<Token> tokens = getTokens(ctx);
        int type;
        for (Token each: tokens) {
            type = getHalsteadType(type);
         }
}