public static GeometricShape removeLowerHypotenuse(ArrayList<GeometricShape> left, ArrayList<GeometricShape> right) {
        GeometricShape x = null;
        if(right.size() != 0 && left.size() != 0 && ((RightTriangle)right.get(0)).getHypotenuse() < ((RightTriangle)left.get(0)).getHypotenuse()  ) {
            x = right.get(0);
            right.remove(0);
        }
        if(right.size() != 0 && left.size() != 0 && ((RightTriangle)left.get(0)).getHypotenuse() < ((RightTriangle)right.get(0)).getHypotenuse() ) {
            x = left.get(0);
            left.remove(0);
        }
        if(right.size() != 0 && left.size() == 0) {
            x = right.get(0);
        }
        if(right.size() == 0 && left.size() != 0) {
            x = left.get(0);
        }
        if(right.size() == 0 && left.size() == 0) {
            return left.get(0);
        }
        return x;
    }