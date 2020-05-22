BufferedReader reader = new BufferedReader(new StringReader("1,2,0\n3,4,5\n6,7,8"));

    StringBuilder sb = new StringBuilder();
    String line = reader.readLine();

    StringBuilder currentLine = new StringBuilder();

    while (line != null)
    {
        currentLine.delete(0, currentLine.capacity());
        currentLine.append(line);
        currentLine.deleteCharAt(1);

        sb.append(currentLine.toString());
        sb.append("\n");

        line = reader.readLine();

    }
    System.out.println(sb.toString());