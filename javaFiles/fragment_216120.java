/**
 * @param args
 */
public static void main(String[] args) {

        //List containing duplicate names 
        List<String> al = new ArrayList<String>(Arrays.asList("JAVA", "JAVA", "JAVA", "CPP", "JAVA", "CPP" ,"C"));
        ArrayList<String> filenameList = new ArrayList<String>();
        Map<String, Integer>counters = new HashMap<String, Integer>();
        for(String fileName : al){
            Integer count = counters.get(fileName);
            boolean toConcat = true;
            if(count == null){
                //First occurence. Is it the only one?
                count = 0;
                if(Collections.frequency(al,fileName) == 1){
                    toConcat = false;
                }
            }
            count += 1;
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