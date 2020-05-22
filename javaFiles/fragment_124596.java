//First, find the normals as if the polygon was clockwise

int sum = 0;
for(int i = 0; i < polygon.npoints; i++) {
    int nextI = (i + 1 == polygon.npoints ? 0 : i + 1);
    sum += (polygon.xpoints[nextI] - polygon.xpoints[i]) * 
        (polygon.ypoints[nextI] + polygon.ypoints[i]);
}

if(sum > 0) {
    //reverse all the normals (multiply them by -1)
}