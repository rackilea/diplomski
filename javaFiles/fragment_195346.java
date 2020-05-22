public static void go4(){
    String[] command={"cmd","/k","cd /phantomjs&&phantomjs chart/chart.js"};
    Process p;
    try{
        p=Runtime.getRuntime().exec(command);
        PrintWriter stdin=new PrintWriter(p.getOutputStream());
        stdin.close();
        int returnCode;
        returnCode=p.waitFor();
        System.out.println("Return code = "+returnCode);

    }catch(IOException e1){
        e1.printStackTrace();

    }catch(InterruptedException e){
        e.printStackTrace();
    }

}