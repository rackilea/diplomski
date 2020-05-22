public static final int WIDTH = 640;
public static final int HEIGHT = 480;
public static final int THRESHOLD = 0.5;

public static void main(String args[])
{
  float imInput[][] = new float[WIDTH][HEIGHT];
  boolean imThresh[][]; 
  imThresh = im2bw(imInput);
}

public static boolean[][] im2bw(float input[][])
{
  boolean output[][] = new boolean[WIDTH][HEIGHT];

  for(int i = 0; i < WIDTH; i++){
    for(int j = 0; j < HEIGHT; j++){
      output[i][j] = input[i][j] > THRESHOLD;
    }
  }
  return(output);
}