public void removeItem() {
    Iterator<ClassA> it = allA.iterator();
    ClassA toRemove = null; 
    while(it.hasNext()){
        ClassA cA = it.next();
        if(cA.hasCondition()){
            toRemove = cA;
            it.remove();
        }
        else {
            cA.update();
        }
    }
    dao.update(allA);
    if(toRemove!=null)dao.remove(toRemove);
}