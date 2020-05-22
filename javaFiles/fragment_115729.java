try {
   TestEnum.valueOf(ss); 
   System.out.println("valid");
} catch (IllegalArgumentException e) {
   System.out.println("invalid");
}