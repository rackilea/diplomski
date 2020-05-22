for (Iterator<SomeClass> i = list.iterator(); i.hasNext();) {
    SomeClass next = i.next();
    if (need_to_remove){
       i.remove(i);                
    }
}