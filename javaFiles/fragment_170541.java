ObservableList<CharSequence> paragraph = textArea.getParagraphs();
    Iterator<CharSequence>  iter = paragraph.iterator();
    try
    {
        BufferedWriter bf = new BufferedWriter(new FileWriter(new File("textArea.txt")));
        while(iter.hasNext())
        {
            CharSequence seq = iter.next();
            bf.append(seq);
            bf.newLine();
        }
        bf.flush();
        bf.close();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }