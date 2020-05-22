import java.util.*;
import java.lang.*;

public class GetExecutionPath
{
  public static void main(String args[]) {
    try{
      String executionPath = System.getProperty("user.dir");
      System.out.print("Executing at =>"+executionPath.replace("\\", "/"));
    }catch (Exception e){
      System.out.println("Exception caught ="+e.getMessage());
    }
  }
}