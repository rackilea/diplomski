public static String getFileToCrawl(String directory){
      File dir = new File(directory);

      String[] children = dir.list();
      if (children == null) {
          return "";
      } else {
          int i=0;
          String filename = children[i];
          while (i<children.length && !filename.contains(".txt")){
              i++;
              filename = children[i];
          }
          return filename;
      }

  }