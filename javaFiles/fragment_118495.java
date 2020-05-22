public class Cod { 
  public static void main(String[] args) { 
    System.out.println(exp()); 
  }
  public static int exp() { 
    int x=10; 
    for (int i=1; i<=3;i++) { 
      x=x*10; 
    } 
    int y=x/10; 
    return y; 
  }
}