if(RangeL%32==0 && RangeR%32==0)
                        input[RangeL/32] = input[RangeL/32] ^
                            Integer.MIN_VALUE;
                    else if(RangeL%32==0 && RangeR%32==1)
                        input[RangeL/32] = input[RangeL/32] ^ 
                            (Integer.MIN_VALUE + (int) Math.pow(2, 30));
                    else if(RangeL%32==0 && RangeR%32 >1)
                        input[RangeL/32] = input[RangeL/32] ^ 
                            (Integer.MIN_VALUE +  Integer.MAX_VALUE +1 -
                             (int) Math.pow(2, 31-(RangeR%32)));
                    else if(RangeL%32==1 && RangeR%32 ==1)
                        input[RangeL/32] = input[RangeL/32] ^ 
                            (int) Math.pow(2, 30);
                    else if(RangeL%32==1 && RangeR%32 >1)
                        input[RangeL/32] = input[RangeL/32] ^ 
                            (Integer.MAX_VALUE +1 -
                             (int) Math.pow(2, 31-(RangeR%32)));
                    else
                        input[RangeL/32] = input[RangeL/32] ^
                            ((int) Math.pow(2, 32-(RangeL%32)) -
                             (int) Math.pow(2, 31-(RangeR%32)) );