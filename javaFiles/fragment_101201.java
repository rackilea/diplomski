blocks = new Block[height][width];

    for(int y = 0; y < height; y++){

    String line = br.readLine();

    String[] tokens = line.split("\\s+");

        for(int x = 0; x < width; x++){

            blocks[x][y]= new Block(x * Block.blockSize ,y * Block.blockSize, Integer.parseInt(tokens[x]));

        }

    }