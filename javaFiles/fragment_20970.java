String s ="hello?1000";

String[] fields = s.split("\\?");

for (String field : fields) {
   System.out.println(field);
}