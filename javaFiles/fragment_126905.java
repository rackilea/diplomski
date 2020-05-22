$> javac -Xlint:unchecked TestInserter.java
TestInserter.java:15: warning: [unchecked] unchecked call to add(E) as a member of the raw type List  
        list.add(new String("55"));  
                 ^  
where E is a type-variable:  
  E extends Object declared in interface List  
1 warning