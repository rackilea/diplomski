public static void main(String[] args) {
    int input = 0;

    try (Scanner reader = new Scanner(System.in)) {

        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(1, 1);

        while (true) {
            do {
                try {
                    System.out.println("Enter the number you would like to factor");
                    input = reader.nextInt();
                } catch (InputMismatchException e){
                    reader.next();
                    input = 0;
                }
            } while(input <= 0);

            if(cache.get(input) != null) {
                System.out.println("Found in cache");
                System.out.println(input + "! = " + cache.get(input));
            } 
            else {
                int result = factorialRecursively(input, cache);
                System.out.println(input + "! = " + result);
            }
        }   
    }
}       

public static int factorialRecursively(int limit, Map<Integer, Integer> cache) {

    int cacheSize = cache.size();
    if (cacheSize < limit) {
        int nextFactorial = cacheSize + 1; 
        System.out.println("Calculating and caching " + nextFactorial + "!");
        cache.put(nextFactorial, cache.get(cacheSize) * nextFactorial); 
        return factorialRecursively(limit, cache);
    }
    else {
        return cache.get(limit);
    }
}