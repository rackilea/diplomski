AtomicReference obj = new AtomicReference();// was volatile obj
... change obj access in execute to match
... replace run method with following:
    ImmutableObject curr;
    do{
       curr = this.test.obj.get();
    }while(!this.test.obj.compareAndSet(curr, new ImmutableObject(curr.getValue()+1)));