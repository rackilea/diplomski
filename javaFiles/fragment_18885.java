static ArrayList<Long> computedValues = new ArrayList<Long>(Arrays.asList(0l,1l));

public static long myF(int N) {
    for (int i = computedValues.size(); i <= N; i++){
         computedValues.add(computedValues.get(i-1) + computedValues.get(i-2));
         System.out.println("array[" + i + "] = " + computedValues.get(i));
    }
    return computedValues.get(N);
}