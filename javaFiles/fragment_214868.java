while ((line = br.readLine()) != null) {
    String strs[] = line.split(DELIM);
    System.out.println(line);        // comment this line if you don't want it printed to console
    //Check if salary is greater than 250,000

    if (Double.parseDouble(strs[5]) > 250000) {  // arrays are zero based so change to 5  
                                                 // or if this is total package then index is 7
        text = text + "\n" + line;
        noLines++;
    }
}