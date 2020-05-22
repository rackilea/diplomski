StringBuilder sb = new StringBuilder();
 Scanner input = new Scanner(file);
 while(input.hasNext()){
    sb.append(input.nextLine());
    sb.append("\n");
    }
 str = sb.toString(); <-- Did you miss it?