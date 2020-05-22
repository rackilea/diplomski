for (int n = 0; n < accelData.size() - 1; n++) {  // size-1 is used since you're accessing n+1 index
     if (accelData.get(n) != accelData.get(n + 1)) {
         if (accelData.get(n) > accelData.get(n + 1)) {
                if (accelData.get(n) >= controlPoint) {
                    if (accelData.get(n) < avg * factor) {
                        underAvgCounter++;
                    }
                    peakCounter++;                        
                }
        } else {
            controlPoint = accelData.get(n + 1);
        }
    } 
}
peakCounter -= underAvgCounter;