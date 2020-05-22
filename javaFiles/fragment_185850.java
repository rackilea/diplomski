COSStream soundStream = new COSStream();
OutputStream os = soundStream.createOutputStream(COSName.FLATE_DECODE);
URL url = new URL("http://cd.textfiles.com/hackchronii/WAV/ALBUNDY1.WAV");
InputStream is = url.openStream();
// FileInputStream is = new FileInputStream(".....WAV");
IOUtils.copy(is, os);
is.close();
os.close();
// See p. 506 in PDF spec, Table 294
soundStream.setInt(COSName.C, 1); // channels
soundStream.setInt(COSName.R, 22050); // sampling rate
//soundStream.setString(COSName.E, "Signed"); // The encoding format for the sample data
soundStream.setInt(COSName.B, 8); // The number of bits per sample value per channel. Default value: 8
// soundStream.setName(COSName.CO, "MP3"); // doesn't work
PDActionSound actionSound = new PDActionSound();
actionSound.getCOSObject().setItem(COSName.getPDFName("Sound"), soundStream);
link.setAction(actionSound);