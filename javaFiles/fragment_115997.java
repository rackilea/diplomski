private static class MyThread implements Runnable{
    private List<bleh> eh = null;

    public MyThread(List<bleh> list){
        eh = list;
    }

    @Override
    public void run(){
        System.out.println("SOME THREAD");
        for(bleh meh : eh){
            System.out.print(meh.toString());
        }
    }
}