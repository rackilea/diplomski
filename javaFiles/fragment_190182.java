public Toplevel(){
    try{
        this.config = new Configuration("testconfig.properties");
    } catch (IOException e) {
        // handle Exception
    }
}