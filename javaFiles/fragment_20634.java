public void getCamerasMegaPixel() {
        Camera camera = Camera.open(0); // For Back Camera
        android.hardware.Camera.Parameters params = camera.getParameters();
        List supportedPictureSizes = params.getSupportedPictureSizes();
        Camera.Size result = null;

        ArrayList<Integer> widthList = new ArrayList<Integer>();
        ArrayList<Integer> heightList = new ArrayList<Integer>();

        for (int i = 0; i < supportedPictureSizes.size(); i++) {
            result = (Camera.Size) supportedPictureSizes.get(i);
            widthList.add(result.width);
            heightList.add(result.height);
        }
        if (widthList.size() != 0 && heightList.size() != 0) {
            System.out.println("Back Megapixel :" + calculateMegaPixel(widthList, heightList));
        }
        camera.release();

        widthList.clear();
        heightList.clear();

        camera = Camera.open(1);        //  For Front Camera
        android.hardware.Camera.Parameters params1 = camera.getParameters();
        List sizes1 = params1.getSupportedPictureSizes();
        Camera.Size result1 = null;
        for (int i = 0; i < sizes1.size(); i++) {
            result1 = (Camera.Size) sizes1.get(i);
            widthList.add(result1.width);
            heightList.add(result1.height);
        }
        if (widthList.size() != 0 && heightList.size() != 0) {
            System.out.println("FRONT Megapixel :" + calculateMegaPixel(widthList, heightList));
        }

        camera.release();
    }

    public float calculateMegaPixel(List<Integer> widthList, List<Integer> heightList) {
        return ((Collections.max(widthList)) * (Collections.max(heightList))) / 1024000;
    }