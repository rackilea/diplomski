@Test
public void testWait(){
    final long INTERVAL = 100;
    long start = System.nanoTime();
    long end=0;
    do{
        end = System.nanoTime();
    }while(start + INTERVAL >= end);
    System.out.println(end - start);
}