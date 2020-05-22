for (int a = 0; a < thisislength; a++) {
        System.out.printf("%3d ", a+1);
        for (int b = 0; b < word.length; b++) {
            if (a >= word[b].length()) {
                System.out.print(' ');
            } else {
                System.out.print(word[b].charAt(a));  
            }
            System.out.print(' ');
        }
        System.out.println();
    }