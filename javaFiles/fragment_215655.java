double[] points = new double[] {
    0, 0,
    0, 1,
    1, 1,
    1, 0
};
Rotate rot = new Rotate(45, 0.5, 0.5);
Translate t = new Translate(5, 7);
Scale sc = new Scale(3, 3);

for (Transform transform : Arrays.asList(rot, t, sc)) {
    transform.transform2DPoints(points, 0, points, 0, 4);
}

System.out.println(Arrays.toString(points));