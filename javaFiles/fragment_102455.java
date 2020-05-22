public interface DBObserver{
      public void notifyNewRecordInserted();
}

public class MyTable extends JTable implements DBOserver{
       public void notifyNewRecordInserted(){
              this.refresh();
       }

       public void refresh(){
            //some code to refresh the table
       }
}

public class DBManager(){
     private List<DBObserver> observers;

     public void addObserver(DBObserver observer){
         this.observers.add(observer);
     }


     public DBObserver  removeObserver(DBObserver observer){
         this.observers.remove(observer);
         return observer;
     }

     public void insert(Record record){
           //some code to insert the new record

           //notify observers
           this.notifyObservers();
     }


     private void notifyObservers(){
        for(DBObserver observer: this.observers){
               observer.notifyNewRecordInserted();
        }
     }
}