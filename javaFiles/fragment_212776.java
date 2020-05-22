import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.max;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;


public class LambdaJtester {

    public static void main(String[] args) {
        final HashMap < String,Double >  mapp = new HashMap<String, Double>();
        mapp.put("s3.5", 3.5);
        mapp.put("s1.5", 1.5);
        mapp.put("s0.5", 0.5);
        mapp.put("s0.6", 0.6);
        mapp.put("2s3.5", 3.5);
        mapp.put("s2.6", 2.6);
        System.out.println(
                select(mapp.entrySet(), having(on(Map.Entry.class).getValue(), 
                        equalTo(max(mapp, on(Double.class)))))
        );
    }
}