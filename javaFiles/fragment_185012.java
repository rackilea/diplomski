FileInputStream inputStream = new FileInputStream(new File("fileIn.txt"));
InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
BufferedReader reader = new BufferedReader(streamReader);
int n = 0;
PrintWriter out = new PrintWriter("fileOut" + ++n + ".txt", "UTF-8");
for (String line;(line = reader.readLine()) != null;) {
    if (line.trim().isEmpty()) {
        out.flush();
        out.close();
        out = new PrintWriter("file" + ++n + ".txt", "UTF-8");
    } else {
        out.println(line);
    }
}
out.flush();
out.close();
reader.close();
streamReader.close();
inputStream.close();