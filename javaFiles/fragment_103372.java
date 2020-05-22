while ((line = br.readLine()) != null) {
    if (startRowCountInt <= counter && counter <= totalRowCountInt) {
        System.out.println(line);
        output.write(line);                 
    }
    counter++;
}