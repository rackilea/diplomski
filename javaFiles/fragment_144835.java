class Headervalues {
    String[] header = new String[3];
}

public void readLogFile() throws Exception
{
    List<HeaderValues> list = new ArrayList<>();
    String currentLine = "";
    BufferedReader reader = new BufferedReader(new FileReader(file(false)));
    while ((currentLine = reader.readLine()) != null)
    {
        if (currentLine.contains("2016") && currentLine.contains("helloworld"))
        {

                String nextBlock = replaceAll(currentLine.substring(22, currentLine.length());

                String[] data = nextBlock.split(";");
                HeaderValues headerValues = new HeaderValues();
                //Assuming data.length will always be 3.
                for (int i = 0, max = data.length; i < max; i++)
                {
                    String[] d = data[i].split("=");
                    //Assuming split will always have size 2
                   headerValues.header[i] = d[1];
                }
                list.add(headerValues)
            }
        }
    }
    reader.close();
}
public void writeContentToCsv() throws Exception
{
    FileWriter writer = new FileWriter(".../file_new.csv");
    for (HeaderValues value : headerValues)
    {
        writer.append(value.header[0]).append(";").append(value.header[1]).append(";").append(value.header[2]);
    }
    writer.close();
}