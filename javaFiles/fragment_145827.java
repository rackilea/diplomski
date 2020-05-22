//TestDebugMeGrammar.g
    //redefinition
    private static DebugEventListener newEventListener() {
        return new SimpleDebugEventListener();
    }

    private static class SimpleDebugEventListener extends
            BlankDebugEventListener {

        private Token lastToken;
        @Override
        public void LT(int i, Object t) {
            System.out.println("Read object \"" + t + "\"");
        }

        @Override
        public void LT(int i, Token t) {
            if (!t.equals(lastToken)){
                System.out.println("Read input \"" + t.getText() + "\"");
                lastToken = t;
            }
        }

        @Override
        //public void enterRule(String ruleName) { // <-- ANTLR 3.0.1
        public void enterRule(String grammarFileName, String ruleName) { //<-- ANTLR 3.4
            System.out.println("Entered rule " + ruleName);
        }

        @Override
        //public void exitRule(String ruleName) { // <-- ANTLR 3.0.1
        public void exitRule(String grammarFileName, String ruleName) { //<-- ANTLR 3.4
            System.out.println("Exited rule " + ruleName);
        }

        @Override
        public void consumeToken(Token token) {
            System.out.println("Consumed \"" + token.getText() + "\"");
        }
    }