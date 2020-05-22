if(binary.charAt(i) == '1'){
            count++; 
            System.out.print("" + count);
        if(count > maxCount) {
            maxCount = count;
        }
     } else {
         count = 0; 
        }