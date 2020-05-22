public  void starTopology(Canvas mCanvas,int noOfFriends,float centerX,float centerY,int radious) {


        final double PI = 3.14;
        final double MARGIN = (2*PI)/noOfFriends;
        final double OFFSETX = centerX;
        final double OFFSETY = centerY;
        final int RADIUS = radious;

        float pointXCoord = 0;
        float pointYCoord = 0;
        double NextPositionOnCircumference = MARGIN;



        Paint myCustomizedBrush = new Paint();
        myCustomizedBrush.setAntiAlias(true);

        myCustomizedBrush.setColor(Color.WHITE);


        for(int i= 0; i < noOfFriends; i++){

            pointXCoord =  (float) (OFFSETX + RADIUS * Math.cos(NextPositionOnCircumference));
            pointYCoord  = (float) (OFFSETY + RADIUS * Math.sin(NextPositionOnCircumference));

            NextPositionOnCircumference += MARGIN;
            mCanvas.drawLine((float)OFFSETX, (float)OFFSETY, pointXCoord, pointYCoord, myCustomizedBrush);
            pointXCoord -= 10;
            pointYCoord -= 10;
            mCanvas.drawBitmap(Utility.FriendProfilePic.get(i), pointXCoord, pointYCoord, null);


        }
        mCanvas.drawCircle((float)OFFSETX, (float)OFFSETY, 5, myCustomizedBrush);