Consumer e = new Eat();
Consumer w = new Water();
if( e.canProcess( myFruit ) )
   e.doSomethingWith( myFruit );
else if ( w.canProcess( myFruit ) )
   w.doSomethingWith( myFruit );

.... etc