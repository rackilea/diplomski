// Start of your code.
            row = new Vector(); int i=0;
        String[] st = lineData.split(","); // Changed
        for (String s : st) { // Changed
            row.addElement(s); // Changed
            if (row.get(i).toString().startsWith("\"") == true) {
                while (row.get(i).toString().endsWith("\"") == false) {
                    p1 = row.get(i).toString();
                    p2 = s.toString(); // Changed
                    row.set(i, p1 + ", " + p2);
                }
                ...// Rest of Code here
        }