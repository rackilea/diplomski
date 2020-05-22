public class HiWorld{        
  private String hi="Hello World!";

  public String getHi(){
    return this.hi;
  }

  public String getMultiply(int a, int b){
    return ""+a*b;
  }

  public static void main(String args[]){            
    HiWorld hm = new HiWorld();
    System.out.println(hm.getHi());
    System.out.println(hm.getMultiply(5,10));                
  }
}