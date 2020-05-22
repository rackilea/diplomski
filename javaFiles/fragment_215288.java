if(prob1==Double.NaN || prob1==Double.POSITIVE_INFINITY || prob1==Double.NEGATIVE_INFINITY ||prob1==0.0) {
                    tmp += 0.0;
                }else {
                    tmp += weights[ngauss]*prob1;
                }
                if(tmp==Double.NaN || tmp==Double.POSITIVE_INFINITY || prob1==Double.NEGATIVE_INFINITY || tmp==0.0) 
                {   
                    logLikelihoods+=0.0;
                }
                else
                {
                    System.out.println("temp-------> "+tmp);
                    logLikelihoods+=Math.log(tmp);
                }