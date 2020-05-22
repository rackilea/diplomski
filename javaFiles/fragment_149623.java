try (FileInputStream source = new FileInputStream(PATH)) {
    Scanner scanner = new Scanner(source);
    Translator translator = new Translator(scanner.nextInt(), scanner.nextInt());
    while(scanner.hasNextInt()){
        m.final_states.add(scanner.nextInt());
    }    
}