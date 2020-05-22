try(BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))){
    String line = null;
    int wonCounter = 0;
    int lostCounter = 0;

    while((line=br.readLine()) != null){
        if(line.contains("Player")){
            if(line.contains("won")){
                wonCounter++;
            }else{
                lostCounter++;
            }
        }
    }

    System.out.println("The total times played is: " + (wonCounter+lostCounter));
    System.out.println("The total times won is: " + wonCounter);
    System.out.println("Return Players value is: " + (wonCounter+lostCounter)*100.0/wonCounter);

} catch (IOException e) {
    e.printStackTrace();
}