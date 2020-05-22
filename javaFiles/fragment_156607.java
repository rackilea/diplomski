final int[] a = {2, 5, 2, 25, 84};
double averageOfA = (double) Arrays.stream(a).sum() / a.length; // A¯ in question
// System.out.println(averageOfA); // prints 23.6
double sumOfA = Arrays.stream(a)
            .mapToDouble(num -> Math.pow(num - averageOfA, 2)) // mapping here
            .sum(); // sum of all such values 
// System.out.println(sumOfA); // prints 4929.2