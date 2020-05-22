contentStream.beginText();

/*x will act as placeholder here*/
byte[] commands = "(500 x/year**) Tj ".getBytes();

/* commands[index_of_x] = (byte)128, where 128 is decimal value of octal
 * 200. (char code for '€' in WinAnsiEncoding).
 * you may want to refer annex D.2, Latin Character Set and Encodings of 
 * PDF specification ISO 32000-1
 */
commands[5] = (byte) 128;

contentStream.appendRawCommands(commands);
contentStream.endText();
contentStream.close();