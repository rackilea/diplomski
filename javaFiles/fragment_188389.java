public class HelloWorld{
    static void method() throws Exception{ throw new Exception(); }

    public static void main(String... args){
        try{method();}
        catch(Throwable th)
        {
            try{ throw new Exception(); }
            catch(Exception e){System.out.print("Exception");}
            finally{System.out.print("finally");}    
        }
    }
}