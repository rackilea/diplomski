String input = "\"One,Two,There\",\"Four,Five,Six\"";

   Matcher m = Pattern.compile("\"[^\"]*\"").matcher(input);
   StringBuffer sb = new StringBuffer();
   while(m.find()) {
       m.appendReplacement(sb, m.group().replaceAll(",", "."));
   }
   m.appendTail(sb);

   String output = sb.toString(); // "One.Two.There","Four.Five.Six"