public static boolean inRange(double start_x, double start_y, double end_x, double end_y,
                              double point_x, double point_y) {
    double dx = end_x - start_x;
    double dy = end_y - start_y;
    double innerProduct = (point_x - start_x)*dx + (point_y - start_y)*dy;
    return 0 <= innerProduct && innerProduct <= dx*dx + dy*dy;
}