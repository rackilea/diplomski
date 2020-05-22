if(RangeR%32==0)
                        input[RangeR/32] = input[RangeL/8] ^ Integer.MIN_VALUE;
                    else 
                        input[RangeR/32] =
                            input[RangeR/8] ^
                            (Integer.MIN_VALUE
                             + ( Integer.MAX_VALUE +1-
                                 (int) Math.pow(2, 31-(RangeL%32))));