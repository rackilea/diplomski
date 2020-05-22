Scanner scanner = new Scanner(new File("d:\\tmp\\zyr.txt"));
    String delimiter = System.getProperty("line.separator");
    scanner.useDelimiter(delimiter);
    StringBuilder sb=new StringBuilder();
    List<String> result=new ArrayList<>();
    while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        if(!(line.trim().length()==0)){
            sb.append(line).append(delimiter);
        }else if(sb.toString().length()>0) {
            result.add(sb.toString());
            sb.setLength(0);
        }
    }
    if(sb.toString().length()>0) {
        result.add(sb.toString());
    }


    System.out.println("first section:");
    System.out.println(result.get(0));
    System.out.println("second section:");
    System.out.println(result.get(1));