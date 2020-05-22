import java.util.Random;
import java.util.Arrays;

public class NeuralNet {
  static final Random rand = new Random();


  static final double[][] teach = new double[][]
  { {0d, 0d, 0d, 0d},
    {0d, 0d, 1d, 0d},
    {0d, 1d, 0d, 1d},
    {0d, 1d, 1d, 0d},
    {1d, 1d, 0d, 1d},
    {1d, 1d, 1d, 0d} };


  public static void main(String[] args) {
    Neural a = new Neural();        
    for(int i = 0; i < 2000; i++){
      int t = rand.nextInt(teach.length);
      a.learn(teach[t][0], teach[t][1], teach[t][2], teach[t][3]);
    }

    System.out.println(a);
    for (int t = 0; t < teach.length; t++) {
      System.out.println(a.react(teach[t][0], teach[t][1], teach[t][2]));
    }
  }

  public static double sigmoid(double u) {
    return 1 / (1 + Math.exp(-u));
  }

  static class Neural {
    static final double INIT_WEIGHT_RANGE = 1 / Math.sqrt(3);
    final double LEARNING_RATE = 0.1;

    double offset = (rand.nextDouble() * 2 - 1) * INIT_WEIGHT_RANGE,
      weight1 = (rand.nextDouble() * 2 - 1) * INIT_WEIGHT_RANGE,
      weight2 = (rand.nextDouble() * 2 - 1) * INIT_WEIGHT_RANGE,
      weight3 = (rand.nextDouble() * 2 - 1) * INIT_WEIGHT_RANGE;

    public double learn(double i1, double i2, double i3, double ideals) {
      double u =
        offset +
        weight1 * i1 +
        weight2 * i2 +
        weight3 * i3;
      u = sigmoid(u);
      double correction = (ideals - u) * LEARNING_RATE;

      offset += correction;
      weight1 += correction * i1;
      weight2 += correction * i2;
      weight3 += correction * i3;

      return u;
    }

    public double react(double i1, double i2, double i3) {
      double u =
        offset +
        weight1 * i1 +
        weight2 * i2 +
        weight3 * i3;
      return sigmoid(u);
    }

    public String toString() {
      // how lazy!
      return Arrays.toString(new double[] {offset, weight1, weight2, weight3});
    }
  }
}