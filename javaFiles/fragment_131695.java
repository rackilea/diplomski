public enum Something {
        SOMETHING_0(0),
        SOMETHING_1(1),
        SOMETHING_2(2);
        final int val;
        Something(int val){
            this.val = val;
        }
        static public  Something byNumber(int number){
            for (Something somthing : Something.values()){
                if (number==somthing.val){
                    return somthing;
                }
            }
            throw new RuntimeException("Value not found");
        }

    }