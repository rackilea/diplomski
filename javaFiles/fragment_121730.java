import bsh.Interpreter;
private void runString(String code){    
    Interpreter interpreter = new Interpreter();
    try {
         interpreter.set("context", this);//set any variable, you can refer to it directly from string
         interpreter.eval(code);//execute code
    }
    catch (Exception e){//handle exception
        e.printStackTrace();
    }
}