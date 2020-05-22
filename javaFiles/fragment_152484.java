String str = "(-2)x^(-2)+(3)x^(1)-(18)x^(-45)";
char[] chars = str.toCharArray();
List<String> exponents = new ArrayList<String>();
for(int i=0; i<chars.length; i++) {
    if(chars[i] == '^') {
        if(++i<chars.length && chars[i] == '(') {
            StringBuilder sb = new StringBuilder();
            while(++i<chars.length && chars[i] != ')') {
                sb.append(chars[i]);
            }
            exponents.add(sb.toString());
        }
    }
}