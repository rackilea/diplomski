for(int j=0;j<tinggi;j++) { 
    for(int i=0;i<lebar;i++) {

        //new (rotated) location for original x/y
        Point rotatedLocation = rotatedLocations[i][j];

        //color from the original
        g.setColor(new Color(original[i][j], original[i][j], original[i][j]));

        //but drawn on the new (rotated) location
        g.drawLine(rotatedLocation.x, rotatedLocation.y, rotatedLocation.x, rotatedLocation.y);
    }
}