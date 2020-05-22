Photographer<?, ?, ?> typicalTourist = photographerProvider.get(mostCommonBirdType);
foo(typicalTourist);

<BT extends BirdType,
 CAM extends BirdCamera<BT>> void foo(Photographer<BT, CAM, ?> typicalTourist) {
    CAM cam = typicalTourist.getPhotographersCamera();
    typicalTourist.examineCamera(cam);
}