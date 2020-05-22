public interface ObservableSubject<T extends SubjectObserver, V> {

   void registerObserver(T observer);

   void removeObserver(T observer);

   void notifyObservers(V notificationPayload); 

}


public interface SubjectObserver<T> {

   void handleNotification(T notificationPayload);
}