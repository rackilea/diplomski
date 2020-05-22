Parent parent = new Parent();
Child child = new Child();
Parent childAsParent = child;

System.out.println(parent.i);             // parent value
System.out.println(child.i);              // child value
System.out.println(((Parent) child) .i);  // parent value by inline cast
System.out.println(childAsParent.i);      // parent value by broader variable type