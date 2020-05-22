PVector edges() {
if (pos.x < 0 + 10 || pos.x > width - 10 || pos.y > 0 +10 || pos.y < height - 10) {
    return PVector.random2D();
 }else{
    return pos;
 }
}