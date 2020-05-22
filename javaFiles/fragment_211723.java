Scanner scanner=new Scanner(System.in);
    while (true) {
        System.out.println("Insert question code:");
        String question = scanner.nextLine();
        if(question.equals("quit")){
            break;
        }
        System.out.println("Insert answer code:");
        String answer = scanner.nextLine();
        if(answer.equals("quit")){
            break;
        }
        service.storeResults(question, answer);
    }