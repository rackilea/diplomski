public class MyClass extends Thread implements Observer{
  private List<AnotherClass> myList = null;
  private Object lock = new Object();

  public MyClass(List<AnotherClass> myList){
    this.myList = new ArrayList(myList);
  }

  public void run(){
    while(true){
       //Do some stuff 
       synchronized(lock) {
        myList.add(NotImportantElement);
       }
    }
  }

  public void doJob{
    synchronized(lock) {
      for(int i=0; i<myList.size; i++){
        ElementClass x = myList.get(i);
        //Do some more stuff
      }
    }
  }
}