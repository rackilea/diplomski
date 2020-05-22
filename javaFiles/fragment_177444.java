final StringBuilder rigaFile = new StringBuilder(riga);
...
          try {
              rigaFile.setLength(0);
              rigaFile.append(r.readLine());
          } catch (IOException e1) {