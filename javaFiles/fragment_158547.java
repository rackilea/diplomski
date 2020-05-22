int imageWidth , imageHeight = 0 ; 

if(isVertical ) {
imageWidth =1280;
imageHeight=960;
}else if (!isVertical ){
imageWidth =960;
imageHeight=1280;
}

Picasso.with(getActivity()) 
            .load(imageUrl) 
            .placeholder(R.drawable.placeholder) 
            .error(R.drawable.error) 
            .resize(imageWidth , imageHeight)
            .centerInside() 
            .into(imageView);