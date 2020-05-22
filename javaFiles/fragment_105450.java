static Set<String> stuff;
static {
    stuff = new HashSet<String>();
    stuff.add("x");
    stuff.add("y");
    stuff.add("z");
}

//Somewhere else in the cosmos

if(stuff.contains(a)) {
    //stuff
}