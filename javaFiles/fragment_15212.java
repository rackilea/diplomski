public static void main(String[] args) {
        int i=0;
        while (i<10) {
            System.out.println(i);
            try {
                if(i ==7){
                    throw new Exception();
                }
                i++;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("out of loop");
    }