boolean flag = false;    

        for (char c : symbols) {
            switch (c) {
            case 'X':
                g2.setColor(Color.BLACK);
                g2.drawImage(wallImg, x, y, width, height, null);
                break;
            case 's':
                g2.setColor(Color.GREEN);
                g2.drawImage(snakeImg, x, y, width, height, null);
                break;
            case 'f':
                //check to see if your flag is true/false
                if(flag){
                    g2.setColor(Color.ORANGE);
                    g2.drawImage(burgerImg, x, y, width, height, null);
                }else{
                    //set first image
                    flag = true;
                }
                break;
            case '.':
                g2.setColor(Color.WHITE);
                g2.fillRect(x, y, width, height);
                break;
            case '\n':
                y += height;
                break;
        }