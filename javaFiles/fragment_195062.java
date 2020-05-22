RelativeLayout.LayoutParams lp=null;
if(position==0)
lp=new RelativeLayout.LayoutParams(-1,0);
else
lp=new RelativeLayout.LayoutParams(-1,-1);

convertView.setLayoutParams(lp);