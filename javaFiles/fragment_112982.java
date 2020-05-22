if (mode == DRAG) {
        matrix.set(savedMatrix);

        matrix.getValues(matrixValues);
        matrixX = matrixValues[2];
        matrixY = matrixValues[5];
        width = matrixValues[0] * (((ImageView) view).getDrawable()
                                .getIntrinsicWidth());
        height = matrixValues[4] * (((ImageView) view).getDrawable()
                                .getIntrinsicHeight());

        dx = event.getX() - start.x;
        dy = event.getY() - start.y;

        //if image will go outside left bound
        if (matrixX + dx < 0){
            dx = -matrixX;
        }
        //if image will go outside right bound
        if(matrixX + dx + width > view.getWidth()){
            dx = view.getWidth() - matrixX - width;
        }
        //if image will go oustside top bound
        if (matrixY + dy < 0){
            dy = -matrixY;
        }
        //if image will go outside bottom bound
        if(matrixY + dy + height > view.getHeight()){
            dy = view.getHeight() - matrixY - height;
        }
        matrix.postTranslate(dx, dy);   
    }