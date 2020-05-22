String result = String.valueOf(int_result);
for (int i=0; i< result.length(); i++) {
    char c = result.charAt(i);
    System.out.println("Digit " + i + " = " + c);
    // And if you need this as an integer
    int digit = Integer.parseInt(""+c); 
}