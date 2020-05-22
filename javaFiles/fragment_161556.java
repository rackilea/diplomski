public class HelloWorld
{
  static int skipStart = 30;
  static int skipEnd = 330;
  static int rangeEnd = 360;

  public static void main(String[] args)
  {
    System.out.println(add(20,5));
    System.out.println(add(20,15));
    System.out.println(add(20,25));
    System.out.println(add(20,35));
    System.out.println(add(20,45));
    System.out.println(add(20,55));
    System.out.println(add(20,65));
    System.out.println(add(20,75));
    System.out.println(add(20,85));
    System.out.println(add(20,95));
    System.out.println(add(20,105));
  }

  public static int add(int curr, int move){

    int movableRange = rangeEnd - (skipEnd-skipStart);
    int result = curr + (move % movableRange);
    result %= rangeEnd;
    if(result>skipStart && result<skipEnd){
        result += (skipEnd-skipStart);
    }
    result %= rangeEnd;
    return result;
  }

}