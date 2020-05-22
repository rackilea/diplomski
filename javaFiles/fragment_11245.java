p = playerBox
t = targetBox

if((t.x>=p.x && t.x<=p.x+p.w) || (t.x+t.w>=p.x && t.x+t.w<=p.x+p.w)){
     if((t.y>=p.y && t.y<=p.y+p.h) || (t.y+t.h>=p.y && t.y+t.h<=p.y+p.h){
          System.out.println("Player p collided with target t!");
     }
}