AudioFile audioFile = AudioFileIO.read(File songFile) // try and catch

MP3File mp3 = (MP3File) audioFile;                    
AbstractID3v2Tag v2Tag = mp3.getID3v2Tag();          

// Since you've mentioned a list
List<TagField> tagList = v2Tag.getFields("TXXX")