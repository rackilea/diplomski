for(int i = 0; i <= l; i++){
            for(int ii = 0; ii < alpLenght; i++){
                if(j < keyList.size()){
                    if(textCharArray[i] == alphabet[ii]){
                        temp = ii + keyList.get(j);
                        System.out.println("Uzkoduotas: " + temp);
                        }
                    j++;
                }