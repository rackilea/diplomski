...
    Scanner in = new Scanner(System.in);
    while(in.hasNextLine()){
        String line = in.nextLine();
        if(line.trim().equals("")){
            break;
        }
        hold = hold.concat(line);
...