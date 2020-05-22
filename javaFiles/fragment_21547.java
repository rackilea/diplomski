for(Iterator<SuperClass> i = list.iterator(); i.hasNext(); ) {
     SuperClass s = i.next();
     if(s instanceof SubClass) {
        i.remove();
     }
}