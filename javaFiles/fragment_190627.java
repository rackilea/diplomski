public BigInt add(BigInt otherBigInt) {
    BigInt result = new BigInt();
    int length = Math.max(digitList.size(), otherBigInt.digitList.size()) - 1;
    int lengthOther = otherBigInt.digitList.size() - 1;
    int temp = 0;
    int whole = 0;
    int carry = 0;

    for (int i = length; i >= 0; i--){
        temp = ( checkAndGet(digitList, i) + checkAndGet(otherBigInt.digitList, i) );
        temp += carry;
        // temp is equal to the sum of this(i) and otherBigInt(i), plus any number carried over.
        if (temp >= 10) {
            whole = temp - 10;
            carry = 1;

            result.digitList.add(whole); 
        }
        else {
            carry = 0;
            result.digitList.add(temp);
        }
    }

    if (carry == 1){
        result.digitList.add(carry);
    }

    //adds any remaining carried number after for loop
    // Supply this code.

    return result;
}

// if the index position being retrieved is larger than the size, assume 0    
private int checkAndGet(List<Integer> input, position) {
    return (input.size() < position) ? input.get(position) : 0;
}