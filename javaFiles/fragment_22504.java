while(condition is true)
{
 A a = new A();
 a.setParameters(); // dont worry about this
 graph.addVertex(a);
 // If you also need it in some kind of array, add it to the array, too.
 // Might be nice to use Vector<A> or List<A> aList = new ArrayList<A>() 
 // since those two can outmaticcaly grow while inserting at the back.
 // Create those outside of the loop if you need them at all.
 i++;
}