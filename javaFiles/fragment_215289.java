if(prob1==Double.NaN || prob1==Double.POSITIVE_INFINITY || prob1==Double.NEGATIVE_INFINITY ||prob1==0.0) {
                    tmp += 0.0;
                    System.out.println("temp Adds 0.0-------> "+tmp);

                }else {
                    tmp += weights[ngauss]*prob1;
                    System.out.println("temp add some value-------> "+tmp);

                }