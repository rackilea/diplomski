StringBuilder builder = new StringBuilder();
for (int i = 0; i < s.length(); i += 2) {
   final int n = Character.getNumericValue(s.charAt(i));
   for (int j = 0; j < n; j++) {
      builder.append(s.charAt(i + 1));
   }
}

System.out.println(builder.toString());