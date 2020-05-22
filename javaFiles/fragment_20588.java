package com.mycontainer;

public class MyContainer {
   // static final singleton object to rely on class loader to create it for you
   // in a thread safe way
   private static final ContainerConfig cConfig = new ContainerConfig();

   // private constructor to prevent instantiation
   private MyContainer() {}

   // getter method for your singleton object
   public static ContainerConfig getContainerConfig() {
      return cConfig;
   }
}