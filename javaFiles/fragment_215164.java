//Reading file
    BufferedReader br = new BufferedReader(new FileReader(inFile));
    br.readLine(); //Get Array Size 

    String line;
    while((line = br.readLine())!= null){
        String[] nums = line.split(" ");
        int val = Integer.valueOf(nums[0]);
        elements.add(Float.valueOf(nums[1]));
    }
    br.close();