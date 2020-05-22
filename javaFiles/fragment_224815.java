public class George {
    private static List<String> lines;

    public static void main (String [] args) throws IOException{
        File f = new File("C:/user.txt");
        lines = Files.readAllLines(f.toPath(),Charset.defaultCharset());
        changeValueOf("Georges", 1234); // the name and the value you want to modify
        Files.write(f.toPath(), changeValueOf("George", 1234), Charset.defaultCharset());
    }

    private static List<String> changeValueOf(String username, int newVal){
        List<String> newLines = new ArrayList<String>();
        for(String line: lines){
            if(line.contains(username)){
                String [] vals = line.split(": ");
                newLines.add(vals[0]+": "+String.valueOf(newVal));
            }else{
                newLines.add(line);
            }

        }
        return newLines;
    }
}