package com;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

class JMXTest {
    public static void main(String args[]) {
        try {
            for ( int i = 0 ; i < args.length ; i++ ) 
                 System.out.println( "args   :" + args[i] );

            RuntimeMXBean mx = ManagementFactory.getRuntimeMXBean();
            System.out.println( "boot  CP:" + mx.getBootClassPath() );
            System.out.println( "      CP:" + mx.getClassPath() );
            System.out.println( "cmd args:" + mx.getInputArguments() );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}