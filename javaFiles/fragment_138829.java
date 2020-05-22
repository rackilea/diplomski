package com.spinner.jackson;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MySerial extends JsonSerializer<ClientObject>
{
   public void serialize(ClientObject value, JsonGenerator jgen,
SerializerProvider provider)
       throws IOException, JsonProcessingException
   {
       jgen.writeObjectFieldStart(value.getClass().getSimpleName()); 
       jgen.writeObjectField(value.getAccounts().get(0).getClass().getSimpleName(), value.getAccounts().get(0)); 
       jgen.writeObjectField(value.getAccounts().get(1).getClass().getSimpleName(), value.getAccounts().get(1)); 
       jgen.writeObjectField(value.getAccounts().get(2).getClass().getSimpleName(), value.getAccounts().get(2)); 
       jgen.writeObjectField(value.getAccounts().get(3).getClass().getSimpleName(), value.getAccounts().get(3)); 

   }

}