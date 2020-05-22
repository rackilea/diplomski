try {
        long dataPosition = 0;
        int data = 0;
        RandomAccessFile raf = new RandomAccessFile("datafile", "r");

        //Get the position of the data to read.
        Scanner scr=new Scanner(System.in);
        dataPosition = scr.nextLong();

        //Go to that position.
        raf.seek(dataPosition);

        //Read the data.
        data = raf.readInt();
        raf.close();

        //Tell the world.
        System.out.println("The data is: " + data);

    } catch (FileNotFoundException e) {
        System.err.println("This shouldn't happen: " + e);
    } catch (IOException e) {
        System.err.println("Writing error: " + e);
    }
    }