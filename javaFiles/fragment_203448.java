final InputStream input = new FileInputStream(inputFile);
final OutputStream output = new FileOutputStream(outputFile);
final ReadableByteChannel inputChannel = Channels.newChannel(input);
final WriteableByteChannel outputChannel = Channels.newChannel(output);
ChannelTools.fastChannelCopy(inputChannel, outputChannel);
inputChannel.close();
outputChannel.close()