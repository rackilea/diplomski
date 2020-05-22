resultsarray[i] = new results();
       while (inputFiles2.hasNext()) {
           String str2 = inputFiles2.nextLine();
           String[] token = str2.split(",");
           System.out.println(token[0] + " " + token[1]+ " " + token[2]);
           resultsarray[i].addResults(token[0], token[1], token[2]);
       }