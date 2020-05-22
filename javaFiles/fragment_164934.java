BufferedReader br = new BufferedReader(new FileReader("C:/dev/gistfile1.txt"));
    long total = 0;
    for(String line; (line = br.readLine())!= null;) {
        String[] parts = line.split("[- ]");
        long start = new BigInteger(parts[0], 16).longValue();
        long end = new BigInteger(parts[1], 16).longValue();
        long size = end - start + 1;
        if (size > 1000000)
            System.out.printf("%,d : %s%n", size, line);
        total += size;
    }
    System.out.println("total: " + total/1024);