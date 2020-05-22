final JPanel jPanelCamera = new JPanel();

jTabbedPane1.addTab("Camera", jPanelCamera);

Webcam webcam = Webcam.getDefault();
webcam.setViewSize(WebcamResolution.VGA.getSize());

WebcamPanel webcamPanel = new WebcamPanel(webcam);
webcamPanel.setFPSDisplayed(true);
webcamPanel.setDisplayDebugInfo(true);
webcamPanel.setImageSizeDisplayed(true);
webcamPanel.setMirrored(true);

jPanelCamera.add(webcamPanel);
jPanelCamera.getParent().revalidate();

System.out.println("Camera OK");