public static void main(String[] args) {
        int [] numberList = {1,2,3,4,5,6,458,243};

        int initialSequence = -1;
        int endSequence = -5;

        for (int num = 0; num<numberList.length;num++) {
            if(num<numberList.length-1) {
                if(initialSequence == -1 && numberList[num] == numberList[num+1]-1) {
                       initialSequence = endSequence = numberList[num]; 
                    }else if(initialSequence == -1 && numberList[num] != numberList[num+1]-1){
                        System.out.print(numberList[num] + " ");
                    }else if(initialSequence != -1 && numberList[num] == numberList[num+1]-1) {
                        endSequence = numberList[num];
                    }
                    else {
                        System.out.print(initialSequence + "-" + (endSequence+1) + " ");
                        initialSequence = -1;
                        endSequence = -5;
                    }

            }else {
                if(initialSequence == -1) System.out.print(numberList[num] + " ");
                else {
                    System.out.print(initialSequence + "-" + (endSequence+1) + " ");
                }
            }
        }
    }