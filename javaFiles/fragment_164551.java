float[] trianglesi=new float[9];
        for (int tt=0; tt<ntri; tt++)
    {

        trianglesi[0]=(float) points[triangles[tt].p1].x;
        trianglesi[1]=(float) points[triangles[tt].p1].y;
        trianglesi[2]=(float) points[triangles[tt].p1].z;

        trianglesi[3]=(float) points[triangles[tt].p2].x;
        trianglesi[4]=(float) points[triangles[tt].p2].y;
        trianglesi[5]=(float) points[triangles[tt].p2].z;

        trianglesi[6]=(float) points[triangles[tt].p3].x;
        trianglesi[7]=(float) points[triangles[tt].p3].y;
        trianglesi[8]=(float) points[triangles[tt].p3].z;

        triangles2.add(trianglesi);
    }