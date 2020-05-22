String hostname = "your.host.name";
int port = 1234;

Socket socket = new Socket(InetAddress.getByName(hostname), port);

ParcelFileDescriptor pfd = ParcelFileDescriptor.fromSocket(socket);

MediaRecorder recorder = new MediaRecorder();

// Additional MediaRecorder setup (output format ... etc.) omitted

recorder.setOutputFile(pfd.getFileDescriptor());

recorder.prepare();

recorder.start();