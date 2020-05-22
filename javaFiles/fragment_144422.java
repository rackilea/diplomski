File f = new File(filepath); 
BufferedReader br = new InputStreamReader(f.getInputStream());
String line = "",content = "";
while((line = br.readLine())!=null) content += line;

MyFile myfile = new MyFile();
StringTokenizer t = new StringTokenizer(content," ");
int status;
String word = "";
while(t.hasMoreTokens())
{
    word = t.nextToken();
    status = myfile.check(word);

    // add the attributes to the to metadata or tracks

 }