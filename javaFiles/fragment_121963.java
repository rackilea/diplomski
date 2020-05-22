input[RangeL/32] = input[RangeL/32] ^ -1;
                    else if(RangeL%32==1)
                        input[RangeL/32] =
                            input[RangeL/32] ^ Integer.MAX_VALUE;
                    else
                        input[RangeL/32] =
                            input[RangeL/32] ^ (int)Math.pow(2, 32-(RangeL%32));