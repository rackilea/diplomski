List<Integer> scalarList = ... // your conversion from a Scalar to a List
List<Integer> channelsList = new ArrayList<Integer>();

Converters.Mat_to_vector_int(channels, channelsList); // this is an existing OpenCV4Android converter

// process channelsList and scalarList, store in channelsList

channels = Converters.vector_int_to_Mat(channelsList); // after processing, convert it back to Mat type