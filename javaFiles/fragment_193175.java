String str = "List of prime numbers between " + x1number + " and " + x1number + ": ";
            //resp.setText(str);
            for(int i = x1number; i <= x2number; i++){
                if(isPrime(i)){
                    resp.setText( str += String.valueOf(i));//see change here
                }
            }