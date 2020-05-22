double nx = point[i].x;
double ny = point[i].y;
for(
    //This part can be tidier
    int count = 0;
    count < CHUNK_SIZE && nx+ux != points[i+1].x && ny+uy != points[i+1].y;
    count++
) {
    nx += ux;
    ny += uy;
}
Point newPoint = new Point(nx, ny);