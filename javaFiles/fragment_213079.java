public void parseFile() throws FileNotFoundException{
    Scanner scan = new Scanner(new File({filelocation}));
    while(scan.hasNext()){
        String line = scan.nextLine().toLowerCase().toString();
        if(line.contains({Exception Details})){
            System.out.println(line);
        }
    }
}