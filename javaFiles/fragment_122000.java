public void moveSnake() {
    if(right) {
        // iterate from the tail forward so we don't overwrite positions that we need
        for(int i = body.size()-1; i>=0;i--) {
            if (i == 0) {
                body.get(i).setX(body.get(i).getX()+20);
            } else {
                // we dont know what direct we are moving, so we need x and y
                body.get(i).setX(body.get(i-1).getX());
                body.get(i).setY(body.get(i-1).getY());
            }

        }
    }if(left) {
        for(int i = body.size()-1; i>=0;i--) {
            if (i == 0) {
                body.get(i).setX(body.get(i).getX()-20);
            } else {
                body.get(i).setX(body.get(i-1).getX());
                body.get(i).setY(body.get(i-1).getY());
            }

        }
    }if(down) {
        for(int i = body.size()-1; i>=0;i--) {
            if (i == 0) {
                body.get(i).setY(body.get(i).getY()+20);
            } else {
                body.get(i).setY(body.get(i-1).getY());
                body.get(i).setX(body.get(i-1).getX());
            }

        }
    }if(up) {
        for(int i = body.size()-1; i>=0;i--) {
            if (i == 0) {
                body.get(i).setY(body.get(i).getY()-20);
            } else {
                body.get(i).setY(body.get(i-1).getY());
                body.get(i).setX(body.get(i-1).getX());
            }

        }
    }
}