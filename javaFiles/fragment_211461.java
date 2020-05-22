public Mat capture() {

    camera.open(1);
    camera.read(image);
    camera.release();

    implemenntCapature();

    return image;

}

public abstract implemenntCapture();