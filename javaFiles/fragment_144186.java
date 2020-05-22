String[] tokens = " tHis  strIng is  rEalLy mEssy  ".split(" ");
StringBuilder result = new StringBuilder();
for(String token : tokens) {
    if(!token.isEmpty()) {
        result.append(token.substring(0, 1).toUpperCase()).append(token.substring(1).toLowerCase());
     }
}
System.out.println(result.toString()); // ThisStringIsReallyMessy