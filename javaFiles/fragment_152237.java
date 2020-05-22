//Main class
public static class MyProgramMain{

//Program main
public static void main(String[] args) {


                //Send 10 threads
        for (int i=0; i<10; i++){

                  //Init class (threaded)
                   MyThreadedClass threadedClass = new MyThreadedClass();

                   //Execute code in the class run() method
                   threadedClass.start();
            }
    }
}