public class MyThread extends Thread{
private static int uniqueId;
private int myId;
MyThread(){
    myId = ++uniqueId;
}
//getters and setters to myId