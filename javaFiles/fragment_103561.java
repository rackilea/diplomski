String scan;
        FileReader file = new FileReader("C:\\Users\\workspace\\learn\\scan.txt");
        BufferedReader br = new BufferedReader(file);

        while((scan = br.readLine()) != null)
                {
            System.out.println(scan);
                }
        br.close();