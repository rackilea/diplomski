public static void main(String[] args){
    Handler fh = new FileHandler("%t/wombat.log");
    Logger.getLogger("").addHandler(fh);
    Logger.getLogger("com.wombat").setLevel("com.wombat",Level.FINEST);
    ...
}