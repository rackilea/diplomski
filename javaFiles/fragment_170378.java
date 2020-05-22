if (initial == false) {
            boolean[] isUsed = new boolean[buttons.length];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int rd = -1;
                    do{
                        rd = (int) (Math.random() * (9 - 0));
                    }while(isUsed[rd]);
                    isUsed[rd] = true;
                    JButton temp = buttons[rd];
                    format[i][j] = temp;
                }
            }
        }