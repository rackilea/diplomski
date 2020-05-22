public void runPython() 
{ //need to call myscript.py and also pass arg1 as its arguments.
  //and also myscript.py path is in C:\Demo\myscript.py

    String[] cmd = {
      "python",
      "C:/Demo/myscript.py",
      this.arg1,
    };
    Runtime.getRuntime().exec(cmd);
}