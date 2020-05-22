public class test implements Iterator<String> {
            static List<String> tokenList = Arrays.asList( "true", "&", "!", "(", "false", "^", "true", ")");
            ArrayList<String> token = new ArrayList<String>();
            static int count = 0;
            // input line to be tokenized
            private String line;

            // the next Token, null if no next Token
            private String nextToken;

            // implement
            public test(String line) {
                this.line = line;

            }

            @Override
            // implement
            public boolean hasNext() {
                // System.out.println(count);
                return count < line.length();
            }

            @Override
            // implement
            public String next() {
                while (hasNext()) {

                    char c = line.charAt(count);
                    if (c == '!' || c == '!' || c == '^' || c == '(' || c == ')') {
                        token.add(Character.toString(c));
                        count++;
                        nextToken = Character.toString(c);
                        return nextToken;
                    } else if (c == 't' || c == 'T') {
                        count++;
                        c = line.charAt(count);
                        if (c == 'r') {
                            count++;
                            c = line.charAt(count);
                        }
                        if (c == 'u') {
                            count++;
                            c = line.charAt(count);
                        }
                        if (c == 'e') {
                            count++;
                            c = line.charAt(count);

                        }if (c == ' ' || c == '!' || c == '!' || c == '^' || c == '(' || c == ')'){
                            token.add("true");

                            nextToken = "true";
                            //count++;
                            return nextToken;
                        }

                    } else if (c == 'f' || c == 'F') {
                        count++;
                        c = line.charAt(count);
                        if (c == 'a') {
                            count++;
                            c = line.charAt(count);
                        }
                        if (c == 'l') {
                            count++;
                            c = line.charAt(count);
                        }
                        if (c == 's') {
                            count++;
                            c = line.charAt(count);
                        }
                        if (c == 'e') {
                            count++;
                            c = line.charAt(count);

                        }
                        if (c == ' ' || c == '!' || c == '!' || c == '^' || c == '(' || c == ')'){
                            token.add("false");

                            nextToken = "false";
                            // count++;
                            return nextToken;
                        }

                    } else if (c == ' ') {
                        count++;
                        nextToken = null;
                    } else {
                        count++;
                        nextToken = null;
                    }

                }


                return nextToken;
            }

            @Override
            // provided, do not change
            public void remove() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException();
            }

            // provided
            public static void main(String[] args) {
                String line;
                // you can play with other inputs on the command line
                if (args.length > 0)
                    line = args[0];
                // or do the standard test
                else
                    line = " ! BAD (true ^ false) % truelybad ";
                System.out.println("line: [" + line + "]");
                test tokIt = new test(line);
                while (tokIt.hasNext()) {
                    String s = tokIt.next();
                    if (s != null && tokenList.contains(s))
                    System.out.println("next token: [" + s + "]");
                }
            }

}