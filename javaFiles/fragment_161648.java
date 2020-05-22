boolean hit = false;
Bullet bullet = gmgr.bulletlist.get(i);
for (int x = 0; x < bullet.size; x++) {
    for (int y = 0; y < bullet .size; y++) {
        for (int mobnum = 0; mobnum < gmgr.moblist.size(); mobnum++) {
            Mob mob = gmgr.moblist.get(mobnum); 
            if(bullet.x+x>=mob.x && bullet.x+x<=mob.x+32){
                if(bullet.y+y>=mob.y&&bullet.y+y<=mob.y+32){
                    gmgr.moblist.remove(mobnum);
                    gmgr.bulletlist.remove(i);
                    hit = true;
                    break; //skip other mobs, bullet is invalid
                }
            }
         }
     if(hit) break; //skip other bullet pixel, bullet is invalid
     }
 if (hit) { //move to the next bullet, reset hit flag
    hit = false;
    break;
 } 
 }