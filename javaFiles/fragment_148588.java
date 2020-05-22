int count=1;
 while (line != null)
            {
                String[] elems = line.split("~");
                breadsList.add(count+" " +elems[0]+ " $" + elems[1]);
                line = in.readLine();
                 count++;
            }