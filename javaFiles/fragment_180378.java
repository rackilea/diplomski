txtValueOfClause.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                int codeBackSpace = ch;
                if (!(ch >= '0' && ch <= '9') && codeBackSpace!=8) {

                    System.out.println("The char you entered is not a number");
                    t.consume();
                }
            }
        });