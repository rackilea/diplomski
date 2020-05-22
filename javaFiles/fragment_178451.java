//compute the smoothed value of non-edge locations insmooth[][]
for(int r=0; r<image.length-1; r++){// x-coordinate of element
  for(int c=0; c<image[r].length-1; c++){ //y-coordinate of element

    int sum1 = 0; //sum of each element's 8 bordering elements and itself

    if(r == 0 || c == 0) {
      smooth[r][c] = image[r][c];
    }
    else {
      sum1 = image[r-1][c-1] + image[r-1][c] + image[r-1][c+1] + image[r][c-1] + image[r][c] + image[r][c+1] +image[r+1][c-1] + image[r+1][c] + image[r+1][c+1];
      smooth[r][c]= sum1 / 9; //average of considered elements becomes new elements
    }
  }
}