String[] info;
while((nextLine = inFile.readLine()) != null)
{
    info  = nextLine.split(";");//; would be the delimiter
    title = info[0];
    department = info[1];
    year = Integer.parseInt(info[2]);
}