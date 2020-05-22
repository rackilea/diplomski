public static void main(String[] args) {
    //List containing duplicate names 
    List<String> al = new ArrayList<String>(Arrays.asList("JAVA", "JAVA", "JAVA", "CPP", "JAVA", "CPP" ,"C"));
    ArrayList<String> filenameList = new ArrayList<String>();
    Map<String, Integer>counters = new HashMap<String, Integer>();
    for(String fileName : al){
        Integer count = counters.get(fileName);
        boolean toConcat = true;
        if(count == null){
            //First occurrence. 
            //The number appended to the filename is the number of occurrences 
            count = Collections.frequency(al,fileName);
            //Is it the only one? If so we won't append anything to the filename
            //beware count is an Integer, not an int so '==' doesn't work 
            if(count.equals(1)){
                toConcat = false;
            }
        } else {
            //we can now decrease the counter
            count -= 1;
        }
        counters.put(fileName, count);
        if(toConcat){
            filenameList.add(fileName.concat("-").concat("" + count));
            //Why not filenameList.add(fileName + "-" + count)); ??
        } else {
            filenameList.add(fileName);
        }
    }
    System.out.println(filenameList);
}