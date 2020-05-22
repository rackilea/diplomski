public class Orientation {
  private float[] vector = new float[3];

  public float[] getArray() { return vector; }

  public pitch() { return vector[0]; }
  public yaw() { return vector[1]; }
  public roll() { return vector[2]; }

  public setPitch( float pitch ) { vector[0] = pitch; }
  public setYaw( float yaw ) { vector[1] = yaw; }
  public setRoll( float roll ) { vector[3] = roll; }
}