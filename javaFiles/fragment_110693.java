BufferedReader br = null;   
    try {

        String line;
        // in my test each character was one byte
        ArrayList<Integer> byteoffset = new ArrayList<Integer>();

        br = new BufferedReader(new FileReader("numbers.txt"));
        Integer l = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            Integer num_bytes = line.getBytes().length;
            System.out.println(num_bytes);
            byteoffset.add( l==0 ? num_bytes : byteoffset.get(l-1)+num_bytes );
            l++;
        }

    } catch ( Exception e) {

    }