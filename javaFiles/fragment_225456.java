import java.util.Arrays;

public class IntArrayNode {

private int[] array;

public IntArrayNode(int[] array) {
  this.array = array;
}

//getter and setter

public boolean equals(Object obj) {
  if (obj != null && obj instanceof IntArrayNode) {
    return Arrays.equals(this.array, ((IntArrayNode) obj).array);
  } else {
    return false;
  }
}

public int hashCode() {
  return Arrays.hashCode(this.array);
}
}