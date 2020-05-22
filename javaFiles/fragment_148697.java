ImageView imageView = new ImageView(this);
LinearLayout.LayoutParams vp = 
    new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 
                    LayoutParams.WRAP_CONTENT);
imageView.setLayoutParams(vp);        
imageView.setImageResource(fetch your ID here);        
someLinearLayout.addView(imageView);