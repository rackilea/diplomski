// Ideally only convert String->byte[] once.  Store these
// arrays somewhere and look them up instead of recalculating.
final byte[] http200 = "200".getBytes("UTF-8"); // Select the correct charset!
// Input doesn't have to be converted!
byte[] input = ChannelBuffer.array();
return Arrays.equals(input, http200);