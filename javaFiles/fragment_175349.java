while (sc.hasNextLine()){
                String[] tokens = sc.nextLine().split("\\s+");
                String houseName = tokens[0];
                for(int i=1; i< tokens.length ; i++)
                    System.out.println(houseName + " " + tokens[i]);
            }