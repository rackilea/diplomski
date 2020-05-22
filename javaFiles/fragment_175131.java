int[] xyReceivedPixel = { 15, 20 };
    int[] xyOriginalPixel = { 30, 15 };
    int toleranceValue = 30;

    boolean status = (xyReceivedPixel[0] < xyOriginalPixel[0] + toleranceValue 
            || xyReceivedPixel[0] > xyOriginalPixel[0] - toleranceValue)
            && (xyReceivedPixel[1] < xyOriginalPixel[1] + toleranceValue 
                    || xyReceivedPixel[1] > xyOriginalPixel[1] - toleranceValue);

    System.out.println(status);