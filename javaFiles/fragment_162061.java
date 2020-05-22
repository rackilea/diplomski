private void executeTestCode(){
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 100, 101, 102, 103};      
    Range[] ranges = Arrays.stream(getRanges(arr)).filter(r -> r != null).toArray(Range[]::new);        
    String output = Arrays.stream(ranges)
            .map(Range::toString)
            .reduce("[", (dynamicString, stringedRange) -> (dynamicString + stringedRange + ", "));
    output = output.substring(0, output.length()-2) + "]";
    System.out.println(output);
}