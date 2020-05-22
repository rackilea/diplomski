try(OutputStream stream = new FileOutputStream(new File(fileName))) {   
    try(OutputStreamWriter out = new OutputStreamWriter(stream, StandardCharsets.UTF_16)) {
        out.write(xmlContent.toString());
        out.write("\n");
    }
} catch (IOException e) {
     System.out.println("Cannot write to file!");
     e.printStackTrace();
}