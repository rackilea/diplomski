package com.mycompany.javatest;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.*;

public class JavaTest {

    static class MyClass {
        private final int someValue = 123;
    }

    static class MyOtherClass {
        private final MyClass mc = new MyClass();
    }

    public static void main(String[] args) {

        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapterFactory(new MyTypeAdapterFactory());
        Gson gson = gb.create();
        MyOtherClass object = new MyOtherClass();

        String json = gson.toJson(object, MyOtherClass.class);
        System.out.println(json);

    }

    static class MyTypeAdapterFactory implements TypeAdapterFactory {

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> tt) {

            if (MyClass.class.isAssignableFrom(tt.getRawType())) {
                return (TypeAdapter<T>) new MyClassAdapter();
            }

            return null;
        }

        private static class MyClassAdapter extends TypeAdapter<MyClass> {

            @Override
            public MyClass read(JsonReader reader) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override
            public void write(JsonWriter writer, MyClass t) throws IOException {
                writer.beginObject();
                writer.name("someValue");
                writer.value(t.someValue); // (Doing some magic to serialize the object here...)
                writer.endObject();
            }
        }
    }
}