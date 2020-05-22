{
    //String s = "sum 1 2";
    String s = "dotimes [sum 1 2] [dotimes [sum 1 2] [sum 1 3]]";
    int depth = 0;
    int pos = 0;        
    for (int c = 0; c <= s.length(); ++c){
        switch (c == s.length() ? ' ' : s.charAt(c)){
        case '[':
            if (++depth == 1){
                pos = c;
            }
            break;
        case ' ':
            if (depth == 0){
                String token = s.substring(pos, c == s.length() ? c : c + 1);
                if (!token.matches("\\s*")){ /*ingore white space*/
                    System.out.println(token);
                }                            
                pos = c + 1;
            }
            break;
        case ']':
            if (--depth == 0){
                String token = s.substring(pos, c + 1);
                if (!token.matches("\\s*")){ /*ingore white space*/
                    System.out.println(token);
                }                                                        
                pos = c + 1;
            }
        break;
        }
    }        
}