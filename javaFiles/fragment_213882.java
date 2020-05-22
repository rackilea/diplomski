MyObjectHolder holder = new MyObjectHolder();
holder.setObject(new Object());

//holder reference id = 1
// holder.object reference id = 2

doIt(holder);

public void doIt(MyObjectHolder methodScopeHolder) {


// methodScpeHolder reference id = 3
// methodScopeHolder.object reference id = 2

}