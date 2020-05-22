package com.mypackage;    

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.mypackage.UploadResponse;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Produces("text/plain")
@Provider
public class UploadResponseProvider implements MessageBodyWriter<UploadResponse> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
         /* You could check the type here, or do some additional checks, but I can just return true, because if it is an UploadResponse (which is inferred via the generic), it's all ok */ 
        return true;
    }

    @Override
    public long getSize(UploadResponse uploadResponse, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(UploadResponse uploadResponse, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        OutputStreamWriter writer = new OutputStreamWriter(entityStream);
        writer.write(new Gson().toJson(Lists.newArrayList(uploadResponse)));
        writer.flush();
    }

}