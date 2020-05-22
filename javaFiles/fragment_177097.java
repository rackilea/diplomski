public class Find {
public static void main(String[] args) {

  File f = new File("D:/");

  Stack stack = new Stack<File>();

  stack.push(f);

  while (!stack.empty())
  {    
      f = (File) stack.pop();
      File []list = f.listFiles();
      try{
          for(int i=0;i<list.length && list.length>0;i++){    
              if(list[i].isFile() && (list[i].getName().contains(".pdf")) ||
                      list[i].getName().contains(".PDF"))
                  System.out.println(list[i].getAbsolutePath());
              if(list[i].isDirectory()) stack.push(list[i]);
          }
      }catch(Exception e){    
  }
}