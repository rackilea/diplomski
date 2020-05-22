A a = new A();
session.save( a );

B b = new B();
b.setA( a );
a.getBList().add( b );
session.save( b );