private Integer[] Imgid = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
    };
    Bitmap bitmapOrg[];
    for (int i = 0; i < Imgid.length; i++) {        
        bitmapOrg[i] = BitmapFactory.decodeResource(getResources(),Imgid[i]);
    }