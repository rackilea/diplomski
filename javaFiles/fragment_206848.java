List<List<Integer>> result = new ArrayList<List<Integer>>();
List<Integer> curr = null;
for (int i = 0; i < big.length; i++) {
    if(i == 0 || (big[i] != big[i-1]+1)) { 
        //if the current element is the first element or doesn't satisfy the condition
        curr = new ArrayList<Integer>(); //create a new list and set it to curr
        result.add(curr); //add the newly created list to the result list
    }
    curr.add(big[i]); //add current element to the curr list
}