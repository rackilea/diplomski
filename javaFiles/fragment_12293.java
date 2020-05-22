class Runner
{
  public static void main(String[] args) 
  {
    NumberShifter rt = new NumberShifter();  
  //demo to see  if code works
    System.out.println(java.util.Arrays.toString(rt.go(new int[]{1, 10, 9, 2, 8, 2, 5, 6, 10, 7, 9, 8, 6, 7, 2, 7, 6, 10, 5, 3},7)));

  //random arrays according to question
  int random[] = new int[20];
    for(int i=0; i<random.length; i++)
    {
      random[i] = (int)(Math.random()*10)+1;
    }
     System.out.println(java.util.Arrays.toString(rt.go(random,7)));
    System.out.println(java.util.Arrays.toString(rt.go(random,7)));
    System.out.println(java.util.Arrays.toString(rt.go(random,7)));

  }

}