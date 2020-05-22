for(int i=0; i<samples.length; i++) {
        currentPoint = samples[i];
        myInstance.setCurrentPoint(currentPoint);
        myInstance.draw(canvas);
        myInstance.invalidate();
    }