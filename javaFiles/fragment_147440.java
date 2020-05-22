//Assumig variables one,two,three,four,five,six are defined above as int
    int[] mNumber = {one, two * 2, three, four * 2, five, six * 2, seven, eight * 2};
        for (int n : mNumber) {
            spiltInt(n);
        }
       showSum(mNumber);

public void spiltInt(int x) {
    String number = String.valueOf(x);
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < number.length(); i++) {
      int j = Character.digit(number.charAt(i), 10);
      list.add(j);
     }
     int result = 0;
     for(Integer i:list){
        result+=i;
     }

      textView.setText(result+"");
  }

  public static void showSum(int[] array){
   int sum = 0;
   int digitSum = 0;
   for(int i=0;i<array.length;i++){
       sum+=array[i];

       String number = String.valueOf(array[i]);
       ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < number.length(); j++) {
         int k = Character.digit(number.charAt(j), 10);
         list.add(k);
      }
      for(Integer digit:list){
        digitSum+=digit;
     }
   }
   //you can set any of these into test view using setText method
   System.out.println(sum+"");
   System.out.println(digitSum+"");
 }