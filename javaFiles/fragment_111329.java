import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
private double N;
public Location() {
  }
public Location(double n) {
    N = n;
  }
@JsonProperty("N")
public double getN() {
    return N;
  }
public void setN(double n) {
    N = n;
  }
@Override
public String toString() {
    return "N=" + N;
  }
}