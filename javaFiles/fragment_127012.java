public interface anInterface extends Library {

   anInterface INSTANCE = (anInterface)Native.loadLibrary((Platform.isWindows() ? "dll" : "dll"),
    anInterface.class); 


    public interface iCallback extends StdCallLibrary.StdCallCallback{
        public int passedFunction(String label);
    }

    public void aFunction(iCallback cb);   
}