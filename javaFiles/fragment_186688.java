@Override
public void mowing_hook() {

    if (! (System.out instanceof SystemOutWrapper)){
        System.setOut(new SystemOutWrapper(System.out));
    }

    //I used 100 as the online editor limitation. But you should change to 50000
    if ("Mowing...100".equals( ((SystemOutWrapper) System.out).getLastLine())){
        System.out.println("Limite reached! Should stop now!");
        stop_mower();
    }
}