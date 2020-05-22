int xy[][]=new int[counting.total()][2];

for (int i = 0; i < counting.total(); i++) {

        CvPoint3D32f circle = new CvPoint3D32f(cvGetSeqElem(couting, i));
        CvPoint middle = cvPointFrom32f(new CvPoint2D32f(circle.x(), circle.y()));
        int radious = Math.round(circle.z()) 
        xy[i][0]=circle.x();
        xy[i][1]=circle.y();    
}      

int total=xy[0][0]+xy[2][0];// x1+x3 =[row 1][col 1]+[row 3][col 2] // since arrays are zero index based ,row 1-->x[0] vice visa ...