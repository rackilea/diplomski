while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (map.containsKey(line)){
                count+= map.get(line);
            }
            map.put(line, count);

        }