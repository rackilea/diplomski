String myClass = "com.package.FirstActivity";
Class<?> myClass = Class.forName(myClass);
Activity obj = (Activity) myClass.newInstance();
Intent myIntent = new Intent(getApplicationContext(), myClass); //Maybe here also obj must be needed

//Noe pass your object here
StaticMethod.processThis(obj, "test");