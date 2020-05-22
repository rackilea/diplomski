DataSource dataSource = myProcessor.getDataOutput();
if(dataSource instanceof URLDataSource){
    PullSourceStream[] streams = ((URLDataSource)dataSource).getStreams();
    if(streams.length > 0){
        Format relax = streams[0].getContentDescriptor().relax();
        if(relax instanceof VideoFormat) {
            System.out.println(((VideoFormat)relax).getFrameRate());
        }
    }
}