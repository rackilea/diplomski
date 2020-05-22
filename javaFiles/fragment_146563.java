// is startIndex really needed? you only ever use it unnecessarily, so, no.
public static int computeSumDivisibleBy3(int[] numbers, int startIndex, int endIndex){
    // End condition, good, but the return value doesn't make any sense
    // You always return the last one in the array, even it's not divisible by 3
    //if (startIndex == endIndex)
    //    return numbers[endIndex];

    // How about this instead (taking the removal of startIndex into consideration)
    if( index == numbers.length - 1) {
        return (numbers[index] % 3 == 0 ? numbers[index] : 0);
    }

    // now, on to regular operations
    // all that's needed is to return the current element, or zero, plus the recursive result
    return (numbers[index] % 3 == 0 ? numbers[index] : 0) + computeSumDivisibleBy3( numbers, ++index );

    // or, if you'd prefer an if statement
    int cur = 0;
    if( current element % 3 is 0 ) {
        cur = current element
    }
    return cur + recurse( numbers, ++index );

    //else{
    //    int sum1 = computeSumDivisibleBy3(numbers, startIndex, endIndex-1);
    //    if (numbers[endIndex] % 3 == 0)
    //        return sum1 + numbers[endIndex];

    //    else

    //return sum1;

    }

}