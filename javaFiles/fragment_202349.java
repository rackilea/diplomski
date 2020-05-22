int num = Character.getNumericValue(first.charAt(0));

String str = "";
for(int i = 0;i < num;i++){
   str += first.charAt(i);
}
System.out.println(str);