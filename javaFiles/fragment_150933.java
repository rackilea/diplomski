String line1 =;
    while((line1 = reader1.readLine()) != null) {
        if(line1.toLowerCase().indexOf(vol) != -1) {
            String[] str = line1.split("=");
            res = str[1].split(" ")[0];
        }
    }