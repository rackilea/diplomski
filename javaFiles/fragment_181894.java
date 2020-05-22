class Main {
  public static void main(String[] args) {
    String str = "Hello, World!, StackOverflow. Test Regex";
    String[] split = str.split("[ .,]+");
    for(String s : split){
      System.out.println(s);
    }    
  }
}