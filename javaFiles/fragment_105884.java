TextView image=new TextView(this);
        LinearLayout.LayoutParams imageParams = new       LinearLayout.LayoutParams(100,100);
        image.setLayoutParams(imageParams);
            image.setBackgroundResource(R.drawable.grey);
        image.setTag(1);
     image.setOnclickListner(this);
}