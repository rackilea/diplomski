public void renderScene(){
        for (int x = 0; x != width; x++) {
            for (int y = 0; y != this.height; y++) {
                this.imageOfScene.setRGB(x, y, giveColorForThisPixel(y));
                for (Geometry geometry: this.geometries) {
                    if (geometry.isHit(x, y)) {
                        this.imageOfScene.setRGB(x, y, geometry.getColor().getRGB());
                    }
                }
            }
        }
    }