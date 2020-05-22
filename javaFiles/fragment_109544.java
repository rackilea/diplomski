CaptureDeviceInfo webcamInfooo = new CaptureDeviceInfo("Camera", new MediaLocator("vfw://0"), null);
MediaLocator camDeviceMediaLocator = webcamInfooo.getLocator();
DataSource source = Manager.createDataSource(camDeviceMediaLocator);
Processor mediaProcessor = Manager.createRealizedProcessor(new ProcessorModel(source, FORMATS, CONTENT_DESCRIPTOR));
//MediaLocator outputMediaLocator = new MediaLocator("rtp://" + addr.getHostAddress() + ":" + PORT + "/video");
MediaLocator outputMediaLocator = new MediaLocator("rtp://192.168.1.6:20000/video");
DataSink dataSink = Manager.createDataSink(mediaProcessor.getDataOutput(), outputMediaLocator);