public StdErrPrintCommand extends Command<String> {

     public StdErrPrintCommand() { super(String.class); }

     @Override
     public <U extends String> void excecute(U arg) { 
            System.err.println(arg);
     }
}