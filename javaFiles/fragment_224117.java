String name[] = {"Percy","Daniel","Layla"};
        int marks[] = {90, 87, 91};
        String merged[] = new String[name.length];
        for (int i=0; i< name.length; i++) {
            merged[i] = name[i]+"=="+marks[i];
        }
        Arrays.sort(merged);
        for(int i = 0; i < merged.length; i++) {
            System.out.println( (i+1) + ". "+ merged[i].split("==")[0] + "\t\t" + merged[i].split("==")[1]);
        }