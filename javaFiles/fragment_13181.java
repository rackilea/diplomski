Iterator<Object> it = Ferry.iterator();
while(it.hasNext()){
    Object i = it.next();
    if (i instanceof Vehicle)
        System.out.println(((Vehicle)i).color);
}