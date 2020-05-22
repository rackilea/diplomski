// Define what it means palindrome
    IntPredicate isPalindrome = n -> new StringBuffer(String.valueOf(n)).reverse().toString().equals(String.valueOf(n));


    OptionalInt max = 
             // Define a stream from 100 to 1000
             IntStream.range(100, 1000)   
             // Map the original stream to a new stream 
             // Basically for each x of the first stream
             // creates a new stream 100-1000 and map each element
             // x of the first stream and y of the second stream
             // to x * y
            .flatMap(x -> IntStream.range(100, 1000).map(y -> x * y))
             // Take only palyndrome of x * y
            .filter(isPalindrome)
            // take the max
            .max();