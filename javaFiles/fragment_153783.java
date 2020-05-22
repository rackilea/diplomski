public static void main(String[] args){
  P4_Icel_Murad_Rolling obj = new P4_Icel_Murad_Rolling();
  obj.rolling(10);
}

public void rolling(int number){
  int counter = 1;
  Random num = new Random();
  for(int i = 0; i < number; i++) {

    int A = num.nextInt(6) + 1;
    System.out.print(A + " ");

    int B = num.nextInt(6) + 1; 
    System.out.print(B + " ");

    int C = num.nextInt(6) + 1; 
    System.out.print(C + "\n");

    if(A == B || A == C || B == C) {
      counter++;
    }
    System.out.println("count = " + counter);
  }        
}