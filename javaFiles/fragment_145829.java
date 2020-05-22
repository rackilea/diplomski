private static class SimpleDebugEventListener extends
            BlankDebugEventListener {

        private LinkedList<String> activeRules = new LinkedList<String>();

        @Override
        public void enterRule(String grammar, String ruleName) {  //ANTLR 3.4
            activeRules.add(ruleName);
        }

        @Override
        public void exitRule(String grammar, String ruleName) { //ANTLR 3.4
            activeRules.removeLast();
        }

        @Override
        public void consumeToken(Token token) {
            System.out.printf("%s consumed \"%s\"%n", formatRules(),
                    token.getText());
        }

        private String formatRules() {
            if (activeRules.size() == 1) {
                return activeRules.getLast();
            } else { 
                StringBuilder builder = new StringBuilder();
                boolean first = true;
                for (String rule : activeRules){
                    if (!first){
                        builder.append(" -> ");
                    } else { 
                        first = false;
                    }
                    builder.append(rule);
                }

                return builder.toString();
            }
        }
    }