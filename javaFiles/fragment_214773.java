while  ((line = br.readLine()) != null) {
    line = br.readLine() # input stream read here twice
    System.out.println(line);
    if(line.toLowerCase().contains("failed")){
           #Apply business Rule.
    }
}