public static int[] rev(int[]x){
    //Creates new array this array is different from karn and local to the method.
    //nothing outside of this method can see this array.
    int[]c=new int[x.length];

    for(int i = 0; i < c.length; i++){
        //Here is where we are swapping the values by placing the first
        //value at the last spot of the array and so on
        c[c.length - i - 1] = x[i];
    }
    //we must return the new array we made and assign it to karn so our 
    //changes will be saved and seen outside of the method
    return c;
  }