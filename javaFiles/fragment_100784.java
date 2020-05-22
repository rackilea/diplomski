String text = CSVFile.readLine();
    while (text != null){
    outfile.println(text);
    text = CSVFile.readLine();

    if (text==null)
        break;