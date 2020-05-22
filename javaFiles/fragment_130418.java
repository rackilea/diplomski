//Set 'velocity' to zero first
game.p.setVelY(0);
game.p.setVelX(0);

if (left_key_down) {
    game.p.setVelX(-1);
} 
if (right_key_down) {
    game.p.setVelX(1);
} 
if (up_key_down) {
    game.p.setVelY(-1);
} 
if (down_key_down) {
    game.p.setVelY(1);
}