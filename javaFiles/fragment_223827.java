String number2 = "36335-36363";
 int[] stream2 = IntStream.range( // stream range
 Integer.parseInt(number2.substring(0, number2.indexOf("-"))), 
 Integer.parseInt(number2.substring(number2.indexOf("-")+1))+1 
).toArray();
 System.out.println(Arrays.toString(stream2));