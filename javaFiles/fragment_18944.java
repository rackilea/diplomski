for(int i = 0; i < by_poss.size(); i++){
             by_poss.set(i, by_poss.get(i)+y_speed); //move the bullet
              if(by_poss.get(i)>=mousework.Height){
                   by_poss.clear();
               }
             bullet=new Rectangle2D.Float(bx_pos_Array.get(i),by_poss.get(i),3,10);  //this line (the first argument)changed


            g2.fill(bullet);
            //g2.draw(bullet);
       }