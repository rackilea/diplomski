package stackoverflow.questions.q18123430;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Q18123430 {

    public static class ObjectA {
        String a;
        int b;
        ArrayList<ObjectB> list;

        @Override
        public String toString() {
            return "ObjectA [a=" + a + ", b=" + b + ", list=" + list + "]";
        }

    }

    public static class ObjectB {
        String a1;
        int b2;
        String c3;

        @Override
        public String toString() {
            return "ObjectB [a1=" + a1 + ", b2=" + b2 + ", c3=" + c3 + "]";
        }

    }

    public static void main(String[] args) {
        String json = "[{  a:\"a\",b:1,list:  [{a1:\"a1\",b2:2,c3:\"c3\"},{a1:\"a1\",b2:2,c3:\"c3\"}]}, {  a:\"a\",b:1,list:  [{a1:\"a1\",b2:2,c3:\"c3\"},{a1:\"a1\",b2:2,c3:\"c3\"}]}]";
        Type listOfObjectA = new TypeToken<List<ObjectA>>() {
        }.getType();

        Gson g = new Gson();
        ArrayList<ObjectA> result = g.fromJson(json, listOfObjectA);
        System.out.println(result);

    }

}