import java.io.*;

public class JavaReader
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("message.txt"));
        String line = in.readLine();

        // for keeping track of the file content
        StringBuffer fileText = new StringBuffer();

        while(line != null) {
            fileText.append(line + "\n");
            line = in.readLine();
        }

        // put file content to a string, display it for a test
        String fileContent = fileText.toString();
        System.out.println(fileContent + "--------------------------------");

        int vowelCount = 0, lineCount = 0;

        // for every char in the file
        for (char ch : fileContent.toCharArray())
        {
            // if this char is a vowel
            if ("aeiou".indexOf(ch) > -1) {
                vowelCount++;
            }
            // if this char is a new line
            if (ch == '\n') {
                lineCount++;
            }
        }
        double wordCount = checkWordCount(fileContent);
        double avgWordCountPerLine = wordCount / lineCount;

        System.out.println("Vowel count: " + vowelCount);
        System.out.println("Line count: " + lineCount);
        System.out.println("Word count: " + wordCount);
        System.out.print("Average word count per line: "+avgWordCountPerLine);
    }

    public static int checkWordCount(String fileContent) {

        // split words by puncutation and whitespace
        String words[] = fileContent.split("[\\n .,;:&?]"); // array of words
        String punctutations = ".,:;";
        boolean isPunctuation = false;
        int wordCount = 0;

        // for every word in the word array
        for (String word : words) {

            // only check if it's a word if the word isn't whitespace
            if (!word.trim().isEmpty()) {
                // for every punctuation
                for (char punctuation : punctutations.toCharArray()) {

                    // if the trimmed word is just a punctuation
                    if (word.trim().equals(String.valueOf(punctuation)))
                    {
                        isPunctuation = true;
                    }
                }

                // only add one to wordCount if the word wasn't punctuation
                if (!isPunctuation) {
                    wordCount++;
                }
            }
        }
        return wordCount;
    }
}