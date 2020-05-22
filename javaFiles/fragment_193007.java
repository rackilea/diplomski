public static String toHTMLEntity(String s) {
          StringBuilder sb = new StringBuilder();
           for (char c : s.toCharArray()) {
                  if (c > 127 || c == '<' || c == '>' || c == '\'' || c == '"' || c == '&' || c == '=' || c == '\n'
                              || c == '\r') {
                        sb.append("&#").append((int) c).append(';');
                 } else {
                        sb.append(c);
                 }
          }
           return sb.toString();
   }