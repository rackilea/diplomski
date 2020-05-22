byte[] data = ...;
ByteArrayInputStream stream = new ByteArrayInputStream(data);
InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
BufferedReader bufferedReader = new BufferedReader(streamReader);

String line;
while ((line = bufferedReader.readLine()) != null)
{
    System.out.println(line);
}