public class WordCount
{
    public static void main(String [] args){
        int words = 0, lines = 0, characters = 0;
        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            lines++;
            String[] lineWords = line.split("\\s+");
            words += lineWords.length;
            for(String word : lineWords)
                characters += word.length();
        }
        StdOut.println("There are " + lines + "lines");
        StdOut.println("There are " + words + "words");
        StdOut.println("There are " + characters + "characters");
    }
}