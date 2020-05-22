public static float betweenPointAndLine(float[] point, float[] lineStart, float[] lineEnd){
        float[] PointThing = new float[3];
        float[] TotalThing = new float[3];
        PointThing[0] = lineStart[0] - point[0];
        PointThing[1] = lineStart[1] - point[1];
        PointThing[2] = lineStart[2] - point[2];

        TotalThing[0] = (PointThing[1]*lineEnd[2] - PointThing[2]*lineEnd[1]);
        TotalThing[1] = -(PointThing[0]*lineEnd[2] - PointThing[2]*lineEnd[0]);
        TotalThing[2] = (PointThing[0]*lineEnd[1] - PointThing[1]*lineEnd[0]);

    float distance = (float) (Math.sqrt(TotalThing[0]*TotalThing[0] + TotalThing[1]*TotalThing[1] + TotalThing[2]*TotalThing[2]) /
                    Math.sqrt(lineEnd[0] * lineEnd[0] + lineEnd[1] * lineEnd[1] + lineEnd[2] * lineEnd[2] ));


    return distance;
}