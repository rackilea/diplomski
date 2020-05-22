package com.sun.btrace.samples;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.Profiler;
import com.sun.btrace.annotations.*;
import com.sun.btrace.*;

@BTrace class Profiling {
@Property
Profiler swingProfiler = BTraceUtils.Profiling.newProfiler();

@OnMethod(
    clazz="com.zerog.ia.installer.util.VariableFacade", 
    method="/.*substitute.*/")
    void entry( String probeMethod) {
        BTraceUtils.print("Entry" );
        BTraceUtils.println(BTraceUtils.timestamp() );
        BTraceUtils.println(probeMethod);
    }

@OnMethod(
    clazz="com.zerog.ia.installer.*", 
    method="/.*/")
    void entry2( @ProbeMethodName(fqn=true) String probeMethod ) {
        BTraceUtils.print("Entry" );
        BTraceUtils.println(BTraceUtils.timestamp() );
        BTraceUtils.println(probeMethod);
    }

@OnMethod(clazz = "com.zerog.ia.installer.*", method = "/.*/", location = @Location(Kind.RETURN))
     void onPrepareReturn(AnyType arg) {
        if (arg != null) {
             BTraceUtils.println(arg);
        }
    }

}