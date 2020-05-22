while ((line = buf.readLine()) != null)   {
    lineCopy=line;
    String [] LineArray=lineCopy.split(",");
    lineCopy=LineArray[0];
    if (word.equals(lineCopy)) {
        System.out.println(line);
        writer1.write(line);


    }

    writer1.newLine();


}
writer.close();