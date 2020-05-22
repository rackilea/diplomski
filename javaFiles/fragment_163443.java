groovy:000> a = s.split()
===> [a, b, c, d]
groovy:000> a.class.isArray()
===> true
groovy:000> a.class.methods
===> [public final void java.lang.Object.wait(long,int) throws java.lang.Interru
ptedException, public final native void java.lang.Object.wait(long) throws java.
lang.InterruptedException, public final void java.lang.Object.wait() throws java
.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Obj
ect), public java.lang.String java.lang.Object.toString(), public native int jav
a.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.g
etClass(), public final native void java.lang.Object.notify(), public final nati
ve void java.lang.Object.notifyAll()]
groovy:000> a.class.methods*.toString().grep {it.contains('removeAll')}
===> []