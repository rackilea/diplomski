String interimByteRange = "/ByteRange [0 " + offsetContentStart + " " + offsetContentEnd + " " + secondPartLength + "]";
int byteRangeLengthDifference = interimByteRange.length() - initByteRange.length();
offsetContentStart = offsetContentStart + byteRangeLengthDifference;
offsetContentEnd = offsetContentEnd + byteRangeLengthDifference;
String finalByteRange = "/ByteRange [0 " + offsetContentStart + " " + offsetContentEnd + " " + secondPartLength + "]";
byteRangeLengthDifference += interimByteRange.length() - finalByteRange.length();
//Replace the ByteRange
docString = docString.replace(initByteRange, finalByteRange);