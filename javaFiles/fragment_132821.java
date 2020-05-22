package Assignment2;

import java.util.Arrays;

public class task {
    public static interface GeometricShapes {
        public double getArea();
        public double getVolume();
    }

    public static abstract class ThreeDShapes implements GeometricShapes {
        protected double a, h;
    }

    public static class Cones extends ThreeDShapes {
        @Override public double getArea() {
            return Math.PI * this.a * Math.sqrt(a * a + h * h);
        }

        @Override public double getVolume() {
            return (1d / 3d) * Math.PI * Math.pow(a, 2) * a * h;
        }

        @Override public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Cone [a=").append(a).append("; ").append("h=")
                    .append(h).append(" ( area=").append(this.getArea())
                    .append("; volume=").append(this.getVolume()).append(" )]");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ThreeDShapes[] { 
            new Cones() {{ a = 3; h = 4;}}, 
            new Cones() {{ a = 4; h = 5;}}
        }));
    }
}