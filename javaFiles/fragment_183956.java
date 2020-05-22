Collections.sort(somelist, new Comparator() { // line 61
    @Override
    public void compare(Object o1, Object o2) {
        // ...
        something.doSomething(); // line 65, something is null here!
        // ...
    }    
});