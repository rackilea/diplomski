public void stage1init() {
        stage1.stageW = 30;
        stage1.stageH = 30;
        stage1.tileSize = 100; 
        stage1.stageStartX = 2;
        stage1.stageStartY = 24;
        stage1.TilePositionX = new double[stage1.stageW][stage1.stageH];
        stage1.TilePositionY = new double[stage1.stageW][stage1.stageH];
        //Layout Stage1
        int W = stage1.stageH;
        int H = stage1.stageW;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                stage1.TilePositionX[i][j] = 100 * j;
                //EDIT: For anyone looking to do something simular, multipy the following by i not j;
                stage1.TilePositionY[i][j] = 100 * i;
            }
        }
    }