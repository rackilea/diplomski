Map <Class, Integer> map = new HashMap<Class, Integer>();
map.put(FileNotFoundException.class, 1);
map.put(NullPointerException.class, 2);
...

Integer action = map.get(ex.getClass());
if (action != null) {
    switch(action) {
    case 1:
        ....
    case 2:
        ...
    }
}