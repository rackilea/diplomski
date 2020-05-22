List<MatOfPoint> contours = new ArrayList<>();
Mat hierarchy = new Mat();
//find all contours
Imgproc.findContours(dilated, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

// Remove contours that aren't close to a square shape
// and remove contour if it has a parent 
List<MatOfPoint> finalContours = new ArrayList<>();
int[] current_hierarchy = new int[4];
for(int i = 0; i < contours.size(); i++){
    double area = Imgproc.contourArea(contours.get(i)); 
    MatOfPoint2f contour2f = new MatOfPoint2f(contours.get(i).toArray());
    double perimeter = Imgproc.arcLength(contour2f, true);
    //Found squareness equation on wiki... 
    //https://en.wikipedia.org/wiki/Shape_factor_(image_analysis_and_microscopy)
    double squareness = 4 * Math.PI * area / Math.pow(perimeter, 2);

    if(squareness >= 0.7 && squareness <= 0.9 && area >= 2000){
        hierarchy.get(0, i, current_hierarchy);
        if (current_hierarchy[3] == -1) {
            finalContours.add(contours.get(i));
        }
    }

}