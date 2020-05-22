private PrintWriter writer;
    private BufferedReader reader;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ClientHandlerThread(
            SSLSocket dataSocket,
            SSLSocket fileSocket,
            Properties userProperties)
    {
        this.dataSocket = dataSocket;
        this.fileSocket = fileSocket;

        this.userProperties = userProperties;

        try
        {
            this.reader = new BufferedReader(new InputStreamReader(this.dataSocket.getInputStream()));
            this.writer = new PrintWriter(this.dataSocket.getOutputStream());
            this.inputStream = fileSocket.getInputStream();
            this.outputStream = fileSocket.getOutputStream();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }