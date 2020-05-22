File file = new File(path, "my_file-name.txt");
       // String filename = "my_file";
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file); //openFileOutput(file, Context.MODE_APPEND);
            double peak1, peak2;
            if(array.length >= 2) {
                peak1 = array[0];
                peak2 = array[1];
            } else { // not enough elements
                return; 
            }
            for (double d : array) {
                // peak2 is greater, leave it;
                // save new value to peak1 ?
                if(peak1 < peak2 && d > peak1) {
                    peak1 = d;
                } else if(d > peak2) { // peak1 is greater or d is less
                    peak2 = d;
                }
                String s = Double.toString(d) + ",";
                outputStream.write(s.getBytes());
            }

            String newline = "/n";
            outputStream.write(newline.getBytes());

            outputStream.close();
            System.out.println("Peaks: " + peak1 + " ; " + peak2);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            //e.printStackTrace();
        }