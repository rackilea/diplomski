###Gson is easy to learn and implement, what we need to know are following two methods

toJson() – Convert Java object to JSON format
fromJson() – Convert JSON into Java object ###

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class GsonExample {
    public static void main(String[] args) {

    Gson gson = new Gson();

    try {

        BufferedReader br = new BufferedReader(
            new FileReader("c:\\file.json"));

        //convert the json string back to object
        DataObject obj = gson.fromJson(br, DataObject.class);

        System.out.println(obj);

    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}