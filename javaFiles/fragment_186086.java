import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PointEnumeration {
    static class Point {
    //a list of integer where index i is the (i+1)'th dimension
    List<Integer> dimensions;

    Point(int step, int numDim){
        this.dimensions = new ArrayList<>();
        for(int i = 0; i < numDim; i++) {
            this.dimensions.add(step);
        }
    }

    Point(int step, Point p){
        this.dimensions = new ArrayList<>();
        this.dimensions.add(step);
        this.dimensions.addAll(p.dimensions);
    }

    int get(int pos) {
        return dimensions.get(pos);
    }
}


private static List<Point> findPoints(int steps, int numDim){
    if(numDim == 1){
        //Only one dimension, add the `steps` to the only dimension
        return Arrays.asList(new Point(steps, 1));
    }

    List<Point> result = new ArrayList<>();

    if(steps == 0){
        //Nothing left, create a point with all zeroes
        return Arrays.asList(new Point(0, numDim));
    }

    //Iterate on the steps
    for(int i = 0; i <= steps; i++){
        //Recurse on the remaining steps and
        //reduce the dimension by 1 (since this dimension will
        // be handled in the next for-each loop)
        List<Point> remaining = findPoints(steps-i, numDim-1);
        for (Point point : remaining) {
            //Append the i'th step to the remaining point
            Point complete = new Point(i, point);
            //This is a complete point for the i'th step
            // and current dimension
            result.add(complete);
        }
    }
    return result;
}

public static void main(String[] args) {
    float stepSize = 0.2f;
    int numDim = 4;

    int steps = (int) Math.ceil(1.0 / stepSize);
    List<Point> res = findPoints(steps, numDim);
    for (Point p : res) {
        for (int coord : p.dimensions) {
            //Convert integer steps to float value
            System.out.print(String.valueOf(coord <= 0 ? 0.0f : (coord / (float) steps)) + ", ");
        }
        System.out.println(" ");
    }
    System.out.println("Total number of points =" + res.size());
}