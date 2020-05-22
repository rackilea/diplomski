FileReader fstream;
      try {
              fstream = new FileReader(filename);
      } catch (FileNotFoundException e) {
              Log.e("meminfo", "File access error " + filename);
              return null;
      }

      BufferedReader in = new BufferedReader(fstream, CHARS_TO_BUFFER);