public class Test{
    public static void main(String[] args){
        int frequency = 0;
        String term = "this morning";
        File tweets = new File(//path to file Tweets.txt);
        String regex = "(?i).*"+term+".*";
        try{
            BufferedReader br = new BufferedReader(new FileReader(tweets));
            String line;

            while((line=br.readLine())!=null){
                if(line.matches(regex)){
                    frequency++;
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(frequency);
    }
}