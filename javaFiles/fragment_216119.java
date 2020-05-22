/**
 * @param args
 */
public static void main(String[] args) {

        //List containing duplicate names 
        List<String> al = new ArrayList<String>(Arrays.asList("JAVA", "JAVA", "JAVA", "CPP", "JAVA", "CPP" ,"C"));
        ArrayList<String> filenameList = new ArrayList<String>();
        //Creates a copy of the collection, which will remain unchanged
        List<String> alCopy = new ArrayList<String>(al);
        for (int i = 0; al.size() > 0;) {
            String fileName = al.get(i);
            int freq = Collections.frequency(al,fileName);
            boolean toConcat = freq != 1;
            if(!toConcat){
                //checks if there was actually only one occurrence of filename 
                //or if it is only the last one
                toConcat =( Collections.frequency(alCopy,fileName) != 1);
            }
            if(toConcat){
                filenameList.add(fileName.concat("-").concat("" + freq));
                //Why not filenameList.add(fileName + "-" + freq)); ??
            } else {
                filenameList.add(fileName);
            }
            al.remove(i); /* removing the element */
        }

        System.out.println(filenameList);
}