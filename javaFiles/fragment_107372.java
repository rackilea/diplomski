File file = new File("file.txt");

Scanner scanner = null;
try
{
    scanner = new Scanner(file);
}
catch (FileNotFoundException e){}

int i = 0;
while(scanner.hasNext("word"))
{
    scanner.next("word");
    i++;
}

System.out.println(i +" occurances of the word 'word'");