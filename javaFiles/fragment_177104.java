int k =0;
 for(int j=0;j<dst.getHeight();j++){
              for(int i=0;i<dst.getWidth();i++, k++){

           origPixel= input.getPixel(i,j);

           color = ........do something special with that pixel transform it whatever



           if(  Math.pow(i - centerX, 2) + ( Math.pow(j - centerY, 2) )  <= 22500 ){

                arr[k]=color;

            }else{

                arr[k]=origPixel;
            }