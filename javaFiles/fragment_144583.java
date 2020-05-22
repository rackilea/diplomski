public class AnyMediaConverter {
    public void main(String[] args) {
        //assumes the following: arg0 is input file and arg1 is output file
        IMediaReader reader = ToolFactory.makeReader(args[0]);
        IMediaWriter writer = ToolFactory.makeWriter(args[1], reader);
        writer.open();
        writer.setForceInterleave(true);
        IContainerFormat outFormat = IContainerFormat.make();
        outFormat.setOutputFormat("3gp", args[1], null);
        IContainer container = writer.getContainer();
        container.open(args[1], IContainer.Type.WRITE, outFormat);
        writer.addVideoStream(0, 0, ICodec.findEncodingCodecByName("h263"), 320, 240);
        writer.addAudioStream(1, 0, ICodec.findEncodingCodecByName("libamr_nb"), 1, 8000);
        reader.addListener(writer);
        while (reader.readPacket() == null);
    }
}