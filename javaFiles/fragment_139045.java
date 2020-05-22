public void runGame() {

    while(gameRunning){
        try{
            Thread.sleep(3);
        }catch(Exception e){
            System.out.println("error");
        }
        Rectangle r = new Rectangle (ballx,bally,20,20);
        Rectangle r2 = new Rectangle (rectX,rectY,30,30);
        Rectangle rE = new Rectangle (enemyX,enemyY,10,10);
        if(count == 1){
        BoxX.add(enemyX);
        BoxY.add(enemyY);
        Ball.add(rE);
        ReverseX.add(1);
        BallXchange.add(enemyX);
        num++;
        indexX.add(num);


        count--;
        }

        //System.out.println("ReverseY" + ReverseY.size());

        if(ballx >= 461)
            ballx = 461;

        if(ballx <= 0)
            ballx = 0;

        if(bally >= 432)
            bally = 432;

        if(bally <= 0)
            bally = 0;





        if(r.intersects(r2)){
            score+=5;

            rectX = (int)(Math.random()*400)+30;
            rectY = (int)(Math.random()*400)+30;

            enemyX = (int)(Math.random()*300)+50;
            enemyY = (int)(Math.random()*300)+50;


            BoxX.add(enemyX);
            BoxY.add(enemyY);


            int x = (int)(Math.random()*10)+1;
            //System.out.println(x);
            if(x > 5){
                ReverseX.add(1);
                BallXchange.add(enemyX);
                num++;
                indexX.add(num);
            }


            if(x <= 5){
                ReverseY.add(1);
                BallYchange.add(enemyY);
                num++;
                indexY.add(num);
            }




            Rectangle En = new Rectangle (enemyX,enemyY,10,10);
            Ball.add(En);


            //System.out.println(Ball);

        }


            for(int i = 0; i < Ball.size(); i++){
                Rectangle w = new Rectangle (BoxX.get(i),BoxY.get(i),10,10);
                Ball.set(i,w);
            }



            for(int i = 0; i < BoxX.size(); i++){
                if(r.intersects(Ball.get(i))){
                    gameRunning = false;
                }
            }





            //System.out.println(ReverseY);

            for(int i = 0; i < ReverseX.size(); i++){
                BallXchange.set(i,BallXchange.get(i)+ReverseX.get(i));
                BoxX.set(indexX.get(i)-1,BallXchange.get(i));
                    if(BallXchange.get(i) >= 470 || BallXchange.get(i) <= 0){
                        ReverseX.set(i,ReverseX.get(i)*-1);
                    }
            }

            for(int i = 0; i < ReverseY.size(); i++){
                BallYchange.set(i,BallYchange.get(i)+ReverseY.get(i));
                BoxY.set(indexY.get(i)-1,BallYchange.get(i));
                    if(BallYchange.get(i) >= 445 || BallYchange.get(i) <= 0){
                        ReverseY.set(i,ReverseY.get(i)*-1);
                    }
            }






        if(right)
            ballx++;
        if(left)
            ballx--;
        if(up)
            bally--;
        if(down)
            bally++;


        repaint();
    }
}