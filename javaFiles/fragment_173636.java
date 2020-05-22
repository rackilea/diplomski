final byte[] lengthBuffer = new byte[3];

int b = is.read(lengthBuffer);

// make sure b was 3 and do your length calculation

final byte buffer = new byte[length];

b = is.read(buffer);

// check b and then you have your bytes