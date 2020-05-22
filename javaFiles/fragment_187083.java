for(int i=0;i<4;i++){
        if(number.charAt(i)!=fakecomputernumber.charAt(i)&&fakecomputernumber.indexOf(number.charAt(i))!=-1){
            result += "-";
            char[] myNameChars = fakecomputernumber.toCharArray();    
            myNameChars[fakecomputernumber.indexOf(number.charAt(i))] = 'x';            
            fakecomputernumber = String.valueOf(myNameChars);
            char[] myNameChars2 = number.toCharArray();
            myNameChars2[i] = 'y';
            number = String.valueOf(myNameChars2);
        }
    }