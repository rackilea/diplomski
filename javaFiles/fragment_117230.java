for(int j=0;;j++) {
        catPos=Integer.parseInt(String.valueOf(chain.charAt(j%chain.length())));
        steps++;
        if(catPos==mousePos)  break;
        if(mousePos==0) mousePos=1;
        else if(mousePos==4) mousePos=3;
        else mousePos+=random.nextInt(2)*2-1;
    }