public int getComparisons() {
        return comparisons;
    } //method to return number of comparisons
    public static Comparable[] findCommonElements(Comparable[][] collections) {
        /*
        I LEARNED THAT WE HAD TO USE MORE THAN TWO ARRAYS, SO IT WAS BACK
        TO THE DRAWING BOARD FOR ME. I FIGURED IT OUT, THOUGH.
        */
        Comparable[] arr1 = collections[0]; //set initial values to 1 Dimensional arrays so the test methods can read their respective values
        Comparable[] arr2 = collections[1];
        Comparable[] arr3 = collections[2];

        /*
        THE FOLLOWING BLOCK OF CODE TAKES ALL THE PERMUTATIONS OF THE 3 ARRAYS (i.e. 1,2,3; 1,3,2; 2,1,3, etc),
        DETERMINES WHICH ARRAY IS THE SHORTEST, AND ADDS THE LONGER TWO ARRAYS TO A QUERY ARRAY.
         */
        if(arr1.length < arr2.length && arr1.length < arr3.length || arr2.length <= arr3.length) { //shortest array will become hash array. the other two will become a combined query array.
            hashArray = arr1;  //these will be utilized below to put into Sets
            queryArray = ArrayUtils.addAll(arr2, arr3);
        }
        else if(arr2.length < arr1.length && arr2.length < arr3.length || arr1.length <= arr3.length) {
            hashArray = arr2;
            queryArray = ArrayUtils.addAll(arr1, arr3);
        }
        else if(arr3.length < arr1.length && arr3.length < arr2.length || arr1.length <= arr2.length) {
            hashArray = arr3;
            queryArray = ArrayUtils.addAll(arr1, arr2);
        }
        HashSet<Comparable> intersectionSet = new HashSet<>(); //initialize Sets
        HashSet<Comparable> arrayToHash = new HashSet<>();
        for(Comparable element : hashArray) { //add shorter array to hashedArray Set
            arrayToHash.add(element);
        }
        //NOTE FROM THE JAVADOC ON THE IMPLEMENTATION OF .contains() USING HASHSET COMPARISONS
        /**
         * <p>This class offers constant time performance for the basic operations
         * (<tt>add</tt>, <tt>remove</tt>, <tt>contains</tt> and <tt>size</tt>),
         * assuming the hash function disperses the elements properly among the
         * buckets.
         */
        for(Comparable element : queryArray) {
            if(element != null) {
                comparisons++; // increment comparisons with each search
            }
            if(arrayToHash.contains(element)) { //search for matches and add to intersectionSet (.contains uses the equals method to determine if an object is within array)
                intersectionSet.add(element);
            }
        }
        return intersectionSet.toArray(new Comparable[0]); //return Set as Array defined in method signature
    }