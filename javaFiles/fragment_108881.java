BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
PrintWriter writer = new PrintWriter(new BufferedWriter(new File(...)))

String line;
while ((line=reader.readLine())!=null) {
    if (line.matches(patternString)) {
        writer.println(line);
    }
}