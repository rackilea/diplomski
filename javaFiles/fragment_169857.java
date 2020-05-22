class Cube {
    private CubeSide bottom = new CubeSide();
    private CubeSide top = new CubeSide();
    private CubeSide left = new CubeSide();
    private CubeSide right = new CubeSide();
    private CubeSide front = new CubeSide();
    private CubeSide back = new CubeSide();
}

class CubeSide {
    private CubePart[][] = new CubePart[3][3];
}

class CubePart {
    private String color = "red";
}