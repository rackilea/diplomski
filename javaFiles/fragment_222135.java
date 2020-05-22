for (int i = 0; i < huisArray.size(); i++) { //you do not step into this piece of code.
            huisArray.get(i).setY(huisArray.get(i).getY() - huisVelocity * delta);
            if (huisArray.get(i).getY() <= 200) {
                huisArray.remove(i);
                i--;
            }               
        }