class SystemOutWrapper extends PrintStream{
    String lastLine;

    public SystemOutWrapper(OutputStream out){
        super(out);
    }

    @Override
    public void println (String str){
        this.lastLine = str;
        super.println(str);
    }

    public String getLastLine(){
        return lastLine;
    }
}