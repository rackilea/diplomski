String content = new Scanner(new File("/titanic.txt")).useDelimiter("\\Z").next();
String[] rows = content.split("\n");
String[][] finalArray = new String[rows.length][];
for(int i=0; i<rows.length; i++)
{
    finalArray[i] = rows[i].split("\\t");
}
//Your desired array is : finalArray;