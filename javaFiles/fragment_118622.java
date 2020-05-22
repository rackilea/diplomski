// MyClient.worker represents the currently running worker thread (if any)
if(far away condition && MyClient.worker == null) {
    Runnable myRunnable = new Runnable() {
        public void run(){
            logger.info("FillMapChunkBuffer started.");

            try {
                short chunkXBuffer = MyClient.nextChunkX;
                short chunkYBuffer = MyClient.nextChunkY;

                int topLeftChunkIndex = MyClient.characterX - (MyClient.chunkWidth / 2) + ((MyClient.characterY - (MyClient.chunkHeight / 2)) * MyClient.mapWidth); //get top left coordinate of chunk
                int topRightChunkIndex = topLeftChunkIndex + MyClient.chunkWidth - 1; //top right coordinate of chunk

                int[] leftChunkSides = new int[MyClient.chunkHeight];
                int[] rightChunkSides = new int[MyClient.chunkHeight];

                for (int i = 0; i < MyClient.chunkHeight; i++){ //figure out the left and right index points for the chunk
                    leftChunkSides[i] = topLeftChunkIndex + (MyClient.mapWidth * i);
                    rightChunkSides[i] = topRightChunkIndex + (MyClient.mapWidth * i);
                }

                // no reason for them to be a member of MyClient
                short[] groundLayerBuffer = MyClient.FillGroundBuffer(leftChunkSides, rightChunkSides);
                short[] buildingLayerBuffer = MyClient.FillBuildingBuffer(leftChunkSides, rightChunkSides);


                MyClient.groundLayer = groundLayerBuffer;
                MyClient.buildingLayer = buildingLayerBuffer;
                MyClient.chunkX = chunkXBuffer;
                MyClient.chunkY = chunkYBuffer;
                MyClient.gamePanel.repaint();
                logger.info("FillMapChunkBuffer done.");
            } finally {
                // in any case clear the worker thread
                MyClient.worker = null;
            }
        }
    };

    // remember that we're currently scanning by remembering the worker directly
    MyClient.worker = new Thread(myRunnable);
    // start worker
    MyClient.worker.start();
}