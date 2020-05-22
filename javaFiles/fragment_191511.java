while(scanner.hasNextLine()){
    String temp = scanner.nextLine();
    while(temp.indexOf("|") != -1){
        content.add(temp.substring(temp.indexOf("|"));
        temp.substring(temp.indexOf("|")+1);
    }    
}