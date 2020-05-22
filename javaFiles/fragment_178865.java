private static int convolution (int [] kernel, int [] pixel){
       int result = 0; 

       for (int i = 0; i < pixel.length; i++){
           result += kernel[i] * pixel[i];
       }

       return (int)(Math.abs(result) / 9);
   }