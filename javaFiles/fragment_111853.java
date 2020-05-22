while (scan.hasNext()) {
    String line = scan.next();
    if(!list.containsKey(line))
        list.put(line,1);
    else {
        list.put(line,list.get(line)+1);
    }
}