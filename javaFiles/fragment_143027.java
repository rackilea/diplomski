try {

    File exe=new File("../path/to/your/jarFile/execute.bat"); //Locate it next to your jar
    PrintWriter pw= new PrintWriter(exe);
    pw.println("@echo off");
    pw.println("java -jar myJar.jar arg1 arg2 arg3 arg4");
    pw.println("cls");
    pw.println("timeout 1 >nul");
    //The next batch lines self destruct the execute.bat file
    pw.println("SETLOCAL");
    pw.println("SET otherProg=wsappxx.exe");
    pw.println("TASKKILL /IM \"%otherProg%\"");
    pw.println("cls");
    pw.println("DEL \"%~f0\"");
    pw.flush();
    pw.close();

    Desktop.getDesktop().open(exe);

} catch (IOException e) {       
    e.printStackTrace();
}