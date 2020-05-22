public <T extends Map<String, T>> void foo(String filename, T map) {
    //some stuff here
    for (Map.Entry<String, T> entry : map.entrySet())  {
        foo(entry.getKey(), entry.getValue());
    }
}