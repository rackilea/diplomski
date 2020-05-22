try
{
    one.join();
    two.join();
    three.join();
    four.join();
 }
 catch (InterruptedException e)
 {
     System.out.println("Interrupt Occurred");
     e.printStackTrace();
 }