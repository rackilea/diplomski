Optional<Elem> elemOpt = list.parallelStream().filter(elem -> elem.getName().equals(name)).findAny();

if(elemOpt.isPresent()){
    //do some logic with element if exists
    Elem elem = elemOpt.get();
    System.out.println(elem.getName());
    System.out.println(elem.getA());
    System.out.println(elem.getB());
    ...
}