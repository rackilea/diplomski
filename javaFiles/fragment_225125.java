public static List<Integer> parseList(List<Integer> input, int difference) {
    List<Integer> output = new ArrayList<Integer> ();
    if (input.size() > 0) {
        // always use first element
        int indexToAdd = -1;
        output.add(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            if ( (input.get(i) - input.get(i-1)) == difference) {
                if (i == input.size()-1) {
                    output.add(input.get(i));               
                }
                else { 
                    indexToAdd = i;
                }
            }
            else {
                if(indexToAdd != -1) {
                    output.add(input.get(indexToAdd));
                    indexToAdd = -1;
                }
                output.add(input.get(i));
            }
        }
    }
    return output;
}