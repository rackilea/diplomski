String input = "0102FFAB";
byte[] bytes = new byte[input.length() / 2];

for( int i = 0; i < input.length(); i+=2)
{
  bytes[i/2] = Integer.decode( "0x" + input.substring( i, i + 2 )  ).byteValue();
}