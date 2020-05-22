@Test
    public void captureThreadTest() throws Exception {
        CameraCapture capture = new CameraCapture();
        Thread captureRunner = capture.startCapture();
        Thread.sleep(10000);

        capture.stopCapture();

        captureRunner.join();
    }