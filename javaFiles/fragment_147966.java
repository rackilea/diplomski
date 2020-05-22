try{
    Method m = myClass.getDeclaredMethod("doSomething");
    println("doSomething: " + m);
  }
  catch(NoSuchMethodException e){
    e.printStackTrace();
  }