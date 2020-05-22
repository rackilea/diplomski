import rx.Observable;
import rx.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import rx.subjects.*;

public class Pagination {
    static HashMap<String,ArrayList<String>> pages = new HashMap<String,ArrayList<String>>();

    public static void main(String[] args) throws InterruptedException {
        pages.put("default", new ArrayList<String>());
        pages.put("2", new ArrayList<String>());
        pages.put("3", new ArrayList<String>());
        pages.put("4", new ArrayList<String>());

        pages.get("default").add("2");
        pages.get("default").add("Maths");
        pages.get("default").add("Chemistry");  

        pages.get("2").add("3");
        pages.get("2").add("Physics");   
        pages.get("2").add("Biology"); 

        pages.get("3").add("4");
        pages.get("3").add("Art");   

        pages.get("4").add("");
        pages.get("4").add("Geography"); 



        Observable<List<String>> ret = Observable.defer(() -> 
        { 
            System.out.println("Building Observable");
            ReplaySubject<String> pagecontrol = ReplaySubject.<String>create(1);
            Observable<List<String>> ret2 = pagecontrol.asObservable().concatMap(aKey -> 
            {
                if (!aKey.equals("")) {
                    return Observable.just(pages.get(aKey)).doOnNext(page -> pagecontrol.onNext(page.get(0)));
                } else {
                    return Observable.<List<String>>empty().doOnCompleted(()->pagecontrol.onCompleted());
                }
            });
            pagecontrol.onNext("default");
            return ret2;
        });
        // Use this if you want to ensure work isn't done again
        ret = ret.cache();
        ret.subscribe(l -> System.out.println("Sub 1 : " + l));
        ret.subscribe(l -> System.out.println("Sub 2 : " + l));
        Thread.sleep(2000L);
    }
}