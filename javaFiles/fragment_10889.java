Point[][] rotatedLocations = ...

for(int j=0;j<tinggi;j++) { 
    for(int i=0;i<lebar;i++) {
        double xr = (i*Math.cos(r))-(j*Math.sin(r));
        double yr = (i*Math.sin(r))+(j*Math.cos(r));
        int xro =  (int) Math.round(xr);
        int yro =  (int) Math.round(yr);
        rotatedLocations[i][j] = new Point(xr, yr);
    }
}