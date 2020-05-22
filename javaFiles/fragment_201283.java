List<String> lines = new ArrayList<>();
        while (line != null) {
            String[] level = ;
            line = reader.readLine();
            if (line.startsWith(";")) {
               levels.add(new Level(lines));
               lines.clear();
            }
            else {
               lines.add(line);
            }
        }