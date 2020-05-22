package stackoverflow.questions.q19478087;

import com.google.gson.Gson;

public class Q19478087 {

    public class Test {
        public int id;
        public Object blob;
        @Override
        public String toString() {
            return "Test [id=" + id + ", blob=" + blob + "]";
        }


    }

    public static void main(String[] str){
        String json1 = "{\"id\": 1, \"blob\": \"example text\"}";
        String json2 = "{\"id\": 2, \"blob\": {\"to\": 1234, \"from\": 4321, \"name\": \"My_Name\"}}";

        Gson g = new Gson();
        Test test1 = g.fromJson(json1, Test.class);
        System.out.println("Test 1: "+ test1);

        Test test2 = g.fromJson(json2, Test.class);
        System.out.println("Test 2: "+ test2);
    }

}