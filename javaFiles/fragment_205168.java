for (int i = 0; i < n; i++) {
        if (scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            if (nextLine.equals(line)) {
                listArray[i] = nextLine;
            }
        }
    }