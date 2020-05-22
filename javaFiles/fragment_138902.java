On your setters after you've set the text call invalidate();
    public void setName(String name) {
    nameView.setText(name);
invalidate();
    }
    public void setInfo(String info){
        infoView.setText(info);
invalidate();
    }
    public void setDegree(String degree){
        degreeView.setText(degree+" °C");
invalidate();
    }
    public void setImage(Bitmap image){
        imageView.setImageBitmap(image);
invalidate();
    }