for (Iterator<Direct> it = list.iterator(); it.hasNext();) {
    Direct d = it.next();
    if(name.equals(d.getName())){
        System.out.println("matches");
    }
}