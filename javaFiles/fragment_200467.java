try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        boolean inside = false;
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("/*Start*/")) {
                inside = true;
                count = 0;
            } else if (line.contains("/*Finish*/")) {
                System.out.println("Found: " + count);
                inside = false;
            } else if (inside) {
                ++count;
            }
        }
        if (inside && count > 0)
            System.out.println("Found: " + count);
    }