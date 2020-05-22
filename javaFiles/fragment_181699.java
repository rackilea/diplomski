List<cloneCounter> clones = new ArrayList<cloneCounter>();     
while (inputStream.hasNextLine()) {
               String line = inputStream.nextLine();
               String[] data = line.split(" ");
               cloneCounter clone = new cloneCounter(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]));
               clones.add(clone);
           }