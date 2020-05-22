public static boolean intersectsWith(BoundingBox boundingBox1, BoundingBox boundingBox2) {
        Vector3 otherMin = boundingBox1.getMin();
        Vector3 otherMax = boundingBox1.getMax();
        Vector3 min = boundingBox2.getMin();
        Vector3 max = boundingBox2.getMax();

        return (min.x < otherMax.x) && (max.x > otherMin.x)
            && (min.y < otherMax.y) && (max.y > otherMin.y)
            && (min.z < otherMax.z) && (max.z > otherMin.z);
    }