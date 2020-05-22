class Thingy {}
Thingy a = new Thingy();
Thingy b = new Thingy();
System.out.println(a == b); // prints false, because a and b refer to different objects

Thingy c = b;
System.out.println(b == c); // prints true, because b and c refer to the same object