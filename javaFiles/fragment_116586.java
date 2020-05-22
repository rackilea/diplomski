@Override
    public void write(List items) throws Exception {

        for (Object o : items) {
                 //do some processing here

                 writeFile(anotherObject);
        }

    private void writeFile (AnotherObject anotherObject) throws IOException {
        File file = new File("name.xml");
        boolean restarted = file.exists();
        FileUtils.setUpOutputFile(file, restarted, true, true);

        StringBuffer sb = new StringBuffer();
        sb.append(xStream.toXML(anotherObject));

        FileOutputStream os = new FileOutputStream(file, true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, Charset.forName("UTF-8")));
        bufferedWriter.write(sb.toString());
        bufferedWriter.close();
    }