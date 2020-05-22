package stackoverflow.questions.q18932252;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Q18932252 {

    public static void main(String[] args){
        String json = "[{\"b\" : {\"a\": \"Hello!\"}}, {\"b\" : {\"a\": \"Hi!\"}}, {\"b\" : {\"a\": \"Hello2!\"}}]";
        Type listOfA = new TypeToken<List<A>>() {}.getType();
        Gson g = new Gson();
        ArrayList<A> result = g.fromJson(json, listOfA);
        System.out.println(result);


    }

}