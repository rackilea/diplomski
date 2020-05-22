package com.google.gson.graph;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Giacomo Tesio
 */
public class InterfaceAdapterFactory  implements TypeAdapterFactory {

    final Map<String, GenericFunction<Gson, TypeAdapter<?>>> adapters;
    private final Class<?> commonInterface;
    public InterfaceAdapterFactory(Class<?> commonInterface, Class<?>[] concreteClasses)
    {
        this.commonInterface = commonInterface;
        this.adapters = new HashMap<String, GenericFunction<Gson, TypeAdapter<?>>>();
        final TypeAdapterFactory me = this;
        for(int i = 0; i < concreteClasses.length; ++i)
        {
            final Class<?> clazz = concreteClasses[i];
            this.adapters.put(clazz.getName(), new GenericFunction<Gson, TypeAdapter<?>>(){
                public TypeAdapter<?> map(Gson gson) {
                     TypeToken<?> type = TypeToken.get(clazz);
                     return gson.getDelegateAdapter(me, type);
                }
            });
        }
    }
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        if(!this.commonInterface.isAssignableFrom(type.getRawType())
           && !this.commonInterface.equals(type.getRawType()))
        {
            return delegate;
        }
        final TypeToken<T> typeToken = type;
        final Gson globalGson = gson;
        return new TypeAdapter<T>() {
           public void write(JsonWriter out, T value) throws IOException {
             out.beginObject();
             out.name("@t");
             out.value(value.getClass().getName());
             out.name("@v");
             delegate.write(out, value);
             out.endObject();
           }
           @SuppressWarnings({"unchecked"})
           public T read(JsonReader in) throws IOException {
               JsonToken peekToken = in.peek();
               if(peekToken == JsonToken.NULL) {
                   in.nextNull();
                   return null;
               }

               in.beginObject();
               String dummy = in.nextName();
               String typeName = in.nextString();
               dummy = in.nextName();
               TypeAdapter<?> specificDelegate = adapters.get(typeName).map(globalGson);
               T result = (T)specificDelegate.read(in);
               in.endObject();
               return result;
           }
        };
    }

}