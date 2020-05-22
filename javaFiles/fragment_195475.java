Context mContext = this;  // I supposed you're in Activity
String imgName = fragenkatalog.get(i).getBild();
int resId = mContext.getResources().getIdentifier(imgName,
                        "drawable", mContext.getApplicationInfo().packageName);
if(resId > 0){
    iv.setImageResource(resId);
}