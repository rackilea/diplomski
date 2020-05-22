String[] allCombinations(String[] input) {
    if (input is empty) {
        return [ "" ]
    }

    String[] result

    String[] childrenCombinations = allCombinations(input[1:])
    foreach char c in input[0] {
        foreach string s in childrenCombinations {
            result += ( c + s )
        }
    }
    return result
}