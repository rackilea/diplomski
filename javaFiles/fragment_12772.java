package com.sun.btrace.samples;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace 
public class OnThrow {  
    @OnMethod(clazz = "javolution.xml.stream.XMLStreamException", method = "<init>", location = @Location(Kind.RETURN))
    public static void endMethod(@Self Exception self) {
        jstack();
    }
}