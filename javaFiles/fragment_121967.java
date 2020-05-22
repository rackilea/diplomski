output[out] = Integer.bitCount(temp1);
                }
                //if the coins range is over multiple numbers in array input[]
                else if(RangeR/32>RangeL/32) {
                    temp1 = input[RangeL/32]<< RangeL%32;
                    temp1 = temp1 >>> RangeL%32;

                    temp2 = input[RangeL/32] >>> (31 - RangeR%32);

                    temp2 = temp2 << (31 - RangeR%32);
                    output[out] =
                        Integer.bitCount(temp1)+ Integer.bitCount(temp2);
                }

                if(RangeR/32 - RangeL/32 > 1) {
                    for(int i=RangeL/32+1; i <RangeR/32 ; i++) {
                        output[out] = output[out] + Integer.bitCount(input[i]);
                    }
                }