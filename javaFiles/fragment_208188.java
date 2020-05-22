public class MyClass{
....
private volatile boolean isLock=false;


gridview.setOnItemClickListener(new OnItemClickListener()
        {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {  
if(isLock){return;} 
                 pos=position;

               findViewById(R.id.view1).setBackgroundColor(getResources().getColor(android.R.color.transparent));


                 switch(flippedCardCounter)
                 {

                 case 0:
                     flippedCardCounter++;    //increase counter
                     v1=v;
                     startFlipAnimation(imageView,v1);
                     break;
                 //flippedCardCounter = 1 -> one card flipped
                 case 1:
                     flippedCardCounter++;    //increase counter
                     isLock=true;
                     v2=v;
                     startFlipAnimation(imageView,v2);
                     im1=((ViewHolder) v1.getTag()).img;
                     im2=((ViewHolder) v2.getTag()).img;

                      Handler handler = new Handler(); 
                      handler.postDelayed(new Runnable() { 
                           public void run() { 
                            ////////////////////////

                            ////////////////////////
                                startUnflipAnimation(im1,v1);
                            startUnflipAnimation(im2,v2);
                               isLock=false; 
                           } 
                      },1000);

                      break;
                 //flippedCardCounter = 2 -> hide two flipped card, flip one card
                 case 2:
                     flippedCardCounter = 0;  
                     flippedCardCounter++;   //increase counter
                     startFlipAnimation(imageView,v);
                     v1=v2=v;
                     break;
            }
                 }

              }); 

....
}