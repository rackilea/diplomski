while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNum++;
            if(line.contains("all")){
                System.out.println("ho hum, i found it on line " +lineNum);

            }