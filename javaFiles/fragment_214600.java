long elapsed = (System.nanoTime() - blinkTimer) / 1000000;
    if(elapsed < 1000){
        //g.drawString("",x,y); Draw String Here
        breakTimer = System.nanoTime();
    }

    long breakElapsed = (System.nanoTime() - breakTimer) / 1000000;
    if(breakElapsed > 500){
        blinkTimer = System.nanoTime();
    }