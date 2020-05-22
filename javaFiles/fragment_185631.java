public class LiveDataUtils {

   public static <T> observeOnce (LifecycleOwner owner, LiveData<T> liveData, Observer<T> observer) {
         liveData.observeForever(o -> {
               observer.onChanged(o);
               removeObserver(owner);
     } 
}