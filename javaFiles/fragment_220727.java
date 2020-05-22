while (line != null) {
     // Print the content on the console
     System.out.println(line);
     strBuilder.append(line);
     line = br.readLine();
}