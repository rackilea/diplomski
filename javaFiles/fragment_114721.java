area1.append("Creating a line graph\n");
  area1.append("Selected file " + f + "\n");
  while (s != null && i < 100) { // your arrays can only hold 1000 ints
    String pair[] = s.split(" ");
    try{
      a[i] = Integer.parseInt(pair[0]);
      b[i] = Integer.parseInt(pair[1]);
      area1.append("X=" + a[i] + " Y=" + b[i] + "\n");
    } catch (NumberFormatException e) {
       area1.append(s + "\n");
    }
    try {
      s = in.readLine();
      i++; // don't forget to increment
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
  area1.append("Finished reading data\n");
  ...