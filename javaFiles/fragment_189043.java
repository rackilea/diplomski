public class JavaTestiMain {
public static void main(String[] args)
  {
    String river = "Hello, World";
    StringBuilder sb=new StringBuilder();
    for (char c : river.toCharArray()){
        if(c == 'e'){
            sb.append('o');
        }
        else if (c=='o'){
            sb.append('e');
        }
        else{
            sb.append(c);
        }
    }
    System.out.println(sb.toString());
  }
}