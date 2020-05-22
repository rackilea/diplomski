import java.util.Arrays;

void setup(){

    float [][] sums = new float[][]{ { 8,6 },
                                     { 4,2 } };

    print("sums:    ");
    System.out.println(Arrays.deepToString(sums));

    float[][] result = matMul(sums,0.5);

    print("result:  ");
    System.out.println(Arrays.deepToString(result));

    print("original:");
    System.out.println(Arrays.deepToString(sums));
}

float[][] matMul(float[][] data,float multiplier){
  // check input data
  if(data == null || data.length == 0){
    println("no data to multiply, returning null");
    return null;
  }
  // make another array of the same shape
  float[][] result = new float[data.length][data[0].length];
  // do the multiplcation, storing the result into the duplicate array
  for(int y = 0; y < data.length; y++){
    for(int x = 0; x < data[y].length; x++){
      result[x][y] = data[x][y] * multiplier;
    }
  }
  // return the result
  return result;
}