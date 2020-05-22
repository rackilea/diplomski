BufferedReader File = new BufferedReader(new FileReader(LOC));//LOC is defined as class variable

//Create an ArrayList to store the words
List<String> words = new ArrayList<String>();

String line;
String delimiter = "\t";
while ((line = File.readLine()) != null)//read the file
{
    String[] wordsInLine = line.split(delimiter);//separate the words
    //delimiter could be a regex here, gotta watch out for that
    for(int i=0, isize = wordsInLine.length(); i < isize; i++){
        words.add(wordsInLine[i]);//put them in a list
    }
}