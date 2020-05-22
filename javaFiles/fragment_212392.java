class Sample {
  Object originalObj;
  public static void main(String[] args) {
   System.out.println(originalObj); // prints null

   tryToCreateInstance(originalObj);
   System.out.println(originalObj); // still prints null

   createInstance(originalObj)
   System.out.println(originalObj); // prints the object hashcode

  originalObj = returnInstance(originalObj);//returns the same reference as originalObj
                                          //is already initialized, if it had been null
                                          // this would have returned a new object
   System.out.println(originalObj); // prints the object hashcode
  }

  public void tryToCreateInstance(Object obj1){
    if(obj1==null) {
       obj1 = new Object(); // relate this with my answer above 
                            // this wont change what originalObj refers
    }
  }

  public void createInstance(){
    if(obj==null) {
       originalObj = new Object(); // refers to the instance variable originalObj
                                   // hence will affect what originalObj refers
    }
  }

  public Object returnInstance(Object obj1) {
    if(obj1==null) {
       return new Object(); // returns a new object
    }
    else {
      return obj1;
    }
  }

}