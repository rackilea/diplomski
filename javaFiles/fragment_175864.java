String input = new String(Files.readAllBytes(Paths.get("file1.xml")));
    final Pattern regex = Pattern.compile("<subtitle>(.+?)</subtitle>");
    final Matcher matcher = regex.matcher(input);
    String modification;
    if (matcher.find()) {
         modification = "<subtitle><![CDATA["+matcher.group(1)+"]]></subtitle>";
         String output = matcher.replaceFirst(modification);
         System.out.println(output);
         FileOutputStream outputStream = new FileOutputStream("file2.xml");
         outputStream.write(output.getBytes());
    }