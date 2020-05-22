// Find all subsets
public List<String> helper(String input) {
    if (input.isEmpty())
        return Collections.singletonList("");

    List<String> result = new ArrayList<>();
    List<String> subResult = helper(input.substring(1));
    result.addAll(subResult);
    for (String s : subResult)
        result.add(input.charAt(0) + s);
    return result;
}

// Print all subsets using the helper method
public void stringPermutations(String input) {
    for (String s : helper(input))
        System.out.println(s);
}