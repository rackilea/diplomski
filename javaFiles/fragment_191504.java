public static List<String> INPUT = Arrays.asList("aaa","aaa","aab","aab","aab","bab");  // my input data
public static List<String> OUTPUT = Arrays.asList("#00001#1#","#00001#2#","#00002#1#","#00002#2#","#00002#3#","#00003#1#"); //my expected response

public static String RESPONSE_FORMAT = "#%05d#%01d#"; //formatting the response into a String;

public static void main(String[] args) {
    List<String> output = new ArrayList<>();
    int counterOccurence = 0;
    int counterChanges = 0;
    String lastLine = "";
    for(String line : INPUT){
        if(lastLine.equals(line)){
            counterOccurence++;
        } else {
            counterOccurence= 1;
            counterChanges++;
        }
        output.add(String.format(RESPONSE_FORMAT, counterChanges,counterOccurence));
        lastLine = line; //remember last line
    }
    System.out.println(output);
    System.out.println("It matches : "+output.equals(OUTPUT));