while(scan.hasNextLine()){
             String line = scan.nextLine();
             String[] tokens = line.split("-");
             String code = tokens[0].trim();
             String description = tokens[1].trim();
             String examiner = tokens[2].trim();
             String moderator = tokens[3].trim();

             courseList.add(code);
             courseList.add(description);

             nameList.add(examiner);
             nameList.add(moderator);
         }