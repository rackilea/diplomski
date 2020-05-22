for (int i = 0; i<lista.size()-1; i++){
                    if (!isPrime(lista.get(i))){
                        lista.remove(lista.get(i));
                        i--;
                    }
                }