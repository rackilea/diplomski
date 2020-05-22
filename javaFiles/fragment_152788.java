package com.example.analyzer;

import com.example.api.Worker;

public class Analyzer {
  // should narrow down exceptions as needed
  public void analyze() throws Exception {  
    // change these paths as need be
    File apiImplV1Jar = new File("api-impl-v1.jar"); 
    File apiImplV2Jar = new File("api-impl-v2.jar");

    ClassLoader apiImplV1Loader = 
      new URLClassLoader(new URL[] { apiImplV1Jar.toURL() });
    ClassLoader apiImplV2Loader = 
      new URLClassLoader(new URL[] { apiImplV2Jar.toURL() });

    Worker workerV1 = 
      (Worker) apiImplV1Loader.loadClass("com.example.impl.WorkerImpl")
                              .newInstance();
    Worker workerV2 = 
      (Worker) apiImplV2Loader.loadClass("com.example.impl.WorkerImpl").
                              .newInstance();

    Comparator c = new Comparator(workerV1.connectAndDoStuff(),
                                  workerV2.connectAndDoStuff());
    c.generateReport();
  }
}