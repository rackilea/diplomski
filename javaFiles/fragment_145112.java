try {
    String sample = "Comment vous appelez-vous?";
    // Prepare the profile before
    DetectorFactory.loadProfile("/language-detection/profiles");
    // Create the Detector
    Detector d = DetectorFactory.create();
    d.append(sample);

    System.out.println(d.detect()); // Ouput: "fr"
} catch (LangDetectException e) {
    e.printStackTrace();
}