}
            }// command==1 => no of heads is to be reported
            else if(command==1) {//if the coins range is contained in a single integer
                if(RangeR/32 == RangeL/32) {
                    temp1 = input[RangeL/32]<< RangeL%32;
                    temp1 = temp1 >>> RangeL%32;
                    temp1 = temp1 >>> (31 - RangeR%32);
                    temp1 = temp1 << (31 - RangeR%32);