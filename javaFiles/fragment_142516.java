String input = "";
br = new BufferedReader(new FileReader(inputFile));
out = new PrintWriter(outputFile);
StringBuilder result = new StringBuilder();
while ((input = br.readLine()) != null)
{
    if(input.contains("HZ"))
    {
        result.append(input.replace("HZ", ""));
        result.append("\n");
    }
    else
    {
        result.append(input.substring(input.indexOf("=") + 1, input.length()));
        result.append(",");
    }
}
System.out.println("result : "+result.toString());