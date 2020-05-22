while(true) {
   synchronized(Test.class) {
       if(testField.get(null) == null) break;
   }
   // ... whatever 
}