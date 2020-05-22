public static void delayedPrint(int delay, String s){
        int charCounter = 0;
        try {
            for (char c : s.toCharArray()){     
                System.out.print(c);
                charCounter++;
                if(charCounter % 80 == 0) System.out.println();//Replace 80 with your console width
                Thread.sleep(delay);
            }
        }catch (InterruptedException e){
        }
        System.out.println();
    }