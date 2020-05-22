String input;
while ((input = br.readLine())!= null && !input.equals("disconnect")) {
   Scanner sc = new Scanner(input);
   String func = sc.next();
   double num1 = sc.nextDouble();
   double num2 = sc.nextDouble();
   ...
}