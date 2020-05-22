public static MyClass getFromString(String myClassName) {
     Object result = null;
     MyClass final_result = null;

     try{
         result = Class.forName(myClassName).getConstructor().newInstance();
         final_result= (MyClass)result;
     }catch(ClassNotFoundException e){} //you must specify concrete Exception here

     return final_result; 
    }