// definitions...

public void ReadFiles() throws FileNotFoundException{
    try (Scanner input = new Scanner(new File("questions.txt"))) {
        String data;
        while(input.hasNextLine()){
            data = input.nextLine();
            String[] Questions = data.split("_");
            points = Integer.parseInt(Questions[0]);
            name= Questions[1];
            a = Questions[2];
            b = Questions[3];
            System.out.println(Arrays.toString(Questions));
        }   
    }
}