public static int process(int identity, int t, int u, String[] array, int index) {
    int result = identity;
    if (array[index].equals("+")) { result = t + u; } 
    else if (array[index].equals("/")) { result =  t / u; } 
    else if (array[index].equals("*")) { result =  t * u; } 
    else if (array[index].equals("-")) { result =  t - u; }
    return result;
}