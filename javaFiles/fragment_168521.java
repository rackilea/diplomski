public int indexOf(String[] array, String name) { 
    for (int i=0; i<array.length; i++)
        if (array[i].toUpperCase().equals(name.toUpperCase()))
            return i;       
    return -1;
}