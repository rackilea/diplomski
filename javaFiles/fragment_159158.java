public static double compute(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) { //addition
                        x += parseTerm();
                    } else if (eat('-')) { //subtraction
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parsePow();
                for (; ; ) {
                    if (eat('×')) { //multiplication
                        x *= parsePow();
                    } else if (eat('÷')) { //division
                        x /= parsePow();
                    } else {
                        return x;
                    }
                }
            }

            double parsePow() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('^')) {
                        x = Math.pow(x, parseFactor());
                    } else {
                        return x;
                    }
                }
            }


            double parseFactor() {
                if (eat('+')) { //unary plus
                    return parsePow(); //unary plus
                }
                if (eat('-')) { //unary minus
                    return -parsePow();
                }
                double x;
                int startPos = this.pos;
                if (eat('(')) { //parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { //numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z' || ch == '!') { //functions
                    while (ch >= 'a' && ch <= 'z' || ch == '!') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) {
                        x = Math.sqrt(x);
                    } else if (func.equals("log")) {
                        x = Math.log10(x);
                    } else if (func.equals("ln")) {
                        x = Math.log(x);
                    } else if (func.equals("sin")) {
                        x = Math.sin(Math.toRadians(x));
                    } else if (func.equals("cos")) {
                        x = Math.cos(Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));
                    } else if (func.equals("sinh")) {
                        x = Math.sinh(x);
                    } else if (func.equals("cosh")) {
                        x = Math.cosh(x);
                    } else if (func.equals("tanh")) {
                        x = Math.tanh(x);
                    } else if (func.equals("!")) {
                        int fact = 1;
                        double number = x;
                        for (int i = 1; i <= number; i++) {
                            fact *= i;
                        }
                        x = fact;
                    } else {
                        throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }
        }.parse();
    }