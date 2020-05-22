Intelligence intel = new Intelligence();
Webcam webcam = Webcam.getDefault();
webcam.open();

CarSnapshot carSnap = new CarSnapshot(webcam.getImage());
String numberPlate = intel.recognize(carSnap);