public static class Song {
      public FileInfo   fileInfo;
      public Properties properties;
      public List<Lyrics>    lyrics;

      public FileInfo getFileInfo()     {return fileInfo;}
      public Properties getProperties() {return properties;}
      public List<Lyrics> getLyrics()                 {return lyrics;}

      public void setFileInfo(FileInfo fileInfo)               {this.fileInfo   = fileInfo;}
      public void setProperties(Properties properties) {this.properties = properties;}
      public void setLyrics(List<Lyrics> lyrics)                     {this.lyrics     = lyrics;}
 }