public String[] GetDevices() {
 String[] devices = {"",};
 /* ... */
     devices = new String[cameraIds.length * 2];
     int j =0;
     for (int i = 0; i < cameraIds.length + 1; i += 2) {
           devices[i] = cameraIds[j++];
           /* .... */
           if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {
               devices[i+1] = "1";
           } else {
               devices[i+1] = "0";
           }
      }
 }