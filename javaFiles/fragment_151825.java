if(ascii >= 65 && ascii <=90){
                    k%=26;
                    if(k+ascii > 90){
                        ascii = (ascii + k - 90)+64; //This is what it should be
                    }
                    else{
                        ascii=ascii+k;
                    }
                }
                if(ascii >= 97 && ascii <=122){
                    k%=26;
                    if(k+ascii > 122){
                        ascii = (ascii + k - 122)+96; //This is what it should be
                    }
                    else{
                        ascii=ascii+k;
                    }
                }