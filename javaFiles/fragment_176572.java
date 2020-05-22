import java.util.Arrays;

void setup(){

    float [][] sums = new float[][]{ { 8,6 },
                                     { 4,2 } };

    print("pre: ");
    System.out.println(Arrays.deepToString(sums));

    matMul(sums,0.5);

    print("post:");
    System.out.println(Arrays.deepToString(sums));
}

void matMul(float[][] data,float multiplier){
  for(int y = 0; y < data.length; y++){
    for(int x = 0; x < data[y].length; x++){
      data[x][y] *= multiplier;
    }
  }
}