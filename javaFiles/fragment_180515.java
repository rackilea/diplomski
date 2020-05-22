public boolean CheckCollision(View v1, View v2) {
    Rect myViewRect = new Rect();
    v1.getHitRect(myViewRect);
    Rect otherViewRect1 = new Rect();
    v2.getHitRect(otherViewRect1);
    return Rect.intersects(myViewRect, otherViewRect1);
}