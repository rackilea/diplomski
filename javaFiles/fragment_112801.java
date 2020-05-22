public class Test {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        VolatileSample sample=new VolatileSample(true);

        Thread1 t1=new Thread1(sample);
        Thread2 t2=new Thread2(sample);

        t1.start();
        t2.start();
        //naive delay
        Thread.sleep(2500);
        sample.setFalse();
    }
}