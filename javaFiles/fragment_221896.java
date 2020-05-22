...
r = new Runnable() {

    @Override
    public void run() {

        if (countscore % 300 == 0) {
            speed = speed + 5;

        }

        bear1.setY(bear1.getY() + speed);
        bear2.setY(bear2.getY() + speed);
        reframeroad();

        boolean isDead = false;

        if ((animImageView.getX() < bear1.getX() + 50 && animImageView.getX() > bear1.getX() - 50) ||
                (animImageView.getX() > bear2.getX() && animImageView.getX() < bear2.getX())) {
            System.out.println("goes inside getx intersects x ");
            dead();
            isDead = true;
        }

        if (Rect.intersects(thiefRect, bear1Rect) || Rect.intersects(thiefRect, bear2Rect)) {
            System.out.println(" goes inside intersects if loop ");
            isDead = true;
            dead();  // this gets called
        }
        if (!isDead) {
            h.postDelayed(this, delay);
        }
   }
}; h.postDelayed(r, speed);


public void dead(){
    //Remove this --> h.removeCallbacksAndMessages(r);

    System.out.println("goes inside dead function");
    ....