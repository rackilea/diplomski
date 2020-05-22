String line = sc.nextLine();
while(sc.hasNextLine()) {
    List<String> process_numbers = new ArrayList<String>();
    if (line.matches(".*process.*")) {
        process_name = line;
        line = sc.nextLine();
    }

    while (!line.matches(".*process.*") && sc.hasNextLine()) {
        process_numbers.add(line);
        line = sc.nextLine();
    }
    if(!sc.hasNextLine()){
         process_numbers.add(line);
    }

    Objects o = new Objects(process_name, process_numbers);
    objects.add(o);

}