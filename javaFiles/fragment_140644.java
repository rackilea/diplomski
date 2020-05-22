public void checkForHide(int first, int last){
        if(foldingCellPosition != -1){
            if(foldingCellPosition < first || foldingCellPosition > last){
                foldingCellPosition = -1;
            }
        }
    }