linear1 = (LinearLayout) findViewById(R.id.linear1);
linear2 = (LinearLayout) findViewById(R.id.linear2);
linear3 = (LinearLayout) findViewById(R.id.linear3);

for(int i=0;i<n;i++)
{
   ImageView iv = new ImageView(this);
   iv.setImageResource(R.id.icon);

   int j = count % 3;  <---- 
   if(j==0)
       linear1.addView(iv);
   else if(j==1)
       linear2.addView(iv);
   else
       linear3.addView(iv); 
}