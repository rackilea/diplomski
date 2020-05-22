package net.betlista.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DeserializationTest {

    public static void main( final String[] args ) {
        final GsonBuilder gb = new GsonBuilder();
        final Gson gson = gb.create();
        // {
        //    "salary": 1234.5,
        //    "name": "John",
        //    "surname": "Doe",
        // }
        final String in = "{\"salary\":1234.5,\"name\":\"John\",\"surname\":\"Doe\"}";
        final FullTimeWorker w = gson.fromJson( in, FullTimeWorker.class );
    }

}