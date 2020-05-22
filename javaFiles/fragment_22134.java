String left = "D:\\DatabaseModifier\\VIS VS EBZVIS\\VIS_Lookup_left.xls";
String right = "D:\\DatabaseModifier\\VIS VS EBZVIS\\EBZVIS_Lookup_right.xls";


   try{
    Process process = new ProcessBuilder("C:\\Program Files\\Beyond Compare 4\\BCompare", "@D:\\DatabaseModifier\\MyScript.txt",left,right,"D:\\DatabaseModifier\\check.html").start();

   }catch(Exception e){

   }