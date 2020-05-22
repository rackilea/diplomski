public class Mover  {

    //make it public if you want to access it directly from an instance (object)
    //of this class (myMover), else keep it private - it will be accessible only
    //in this class
    //you could also make it static but that will have limitations (can be accessed
    //only from static functions and value will be shared by all objects of this class
    public String compute;

    public static void main(String[] args) throws IOException, InterruptedException {   
       //an object of this class needs to be created only if compute is non-static
       Mover myMover = new Mover();

       //access compute variable using myMover.compute

       // invoke your methods using myMover.copyFolder() etc
    }
}