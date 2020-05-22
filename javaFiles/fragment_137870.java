agrondimg = new HBackgroundImage(afbeelding);
agrondimg.load(this);
try{
    bgConfiguration.displayImage(agrondimg);
} catch (Exception s){
    s.printStackTrace();
}