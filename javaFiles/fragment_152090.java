public class YourClass
{
   public int pleaseGiveYourFunctionProperNames(String s){
      GlobalVariablesExample.GlobalVariable = s;
   }
   public void thisFunctionPrintsValueOfMyStringVar(){
      System.out.println(GlobalVariablesExample.GlobalVariable);
   }
}