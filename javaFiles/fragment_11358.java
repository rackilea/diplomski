private static boolean fits(int[] weights, int[] boxes, int i) {
    if (i == weights.length)
        return true;

    for (int j = 0; j < boxes.length; j++) {
        if (weights[i] <= boxes[j]) {
            boxes[j] -= weights[i];
            if (fits(weights, boxes, i+1))
                return true;

            boxes[j] += weights[i];
        }
    }

    return false;
}