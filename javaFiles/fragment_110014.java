DataSource dataSource = myProcessor.getDataOutput();
if(dataSource instanceof PullBufferDataSource){ // or PushBufferDataSource
    PullBufferStream[] streams = ((PullBufferDataSource)dataSource).getStreams();
    if(streams.length > 0){
        Format relax = streams[0].getFormat();
        if(relax instanceof VideoFormat) {
            System.out.println(((VideoFormat)relax).getFrameRate());
        }
    }
}