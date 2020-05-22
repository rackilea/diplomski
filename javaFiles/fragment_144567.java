String file = "/home/sam/PycharmProjects/train.bin";
   FileInputStream fis = new FileInputStream(file);
   DataInputStream ds = new DataInputStream(fis);

   int count = ds.available();

   short features[][] = new short[count / (2 * 2048)][2048]; //i know the size of my data.
   int idx = 0;


   while (ds.available() > 0) {

    // read two bytes from data input, return short
    short k = ds.readShort();

    int row = idx / 2048;
    int column = idx % 2048;


    features[row][column] = k;
    idx++;

   }