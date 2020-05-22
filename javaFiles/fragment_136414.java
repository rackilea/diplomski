public boolean checkPosition(float x, float y, float sx, float sy, float ex, float ey) {
        float mX = ex - sx;
        float mY = ey - sy;
        float smX = sx - ex;
        float smY = sy - ey;
        float pmX = mX;
        float pmY = mY;
        float psmX = smX;
        float psmY = smY;
        float yY = ey - y;
        float xX = ex - x;
        float sX = sx - x;
        float sY = sy - y;
        float m = mY / mX;
        float b = sy - (m * sx);
        if (mX < 0) {
            pmX = mX * - 1;
        }
        if (mY < 0) {
            pmY = mY * - 1;
        }
        if (smX < 0) {
            psmX = smX * - 1;
        }
        if (smY < 0) {
            psmY = smY * - 1;
        }
        if (yY < 0) {
            yY = yY * - 1;
        }
        if (xX < 0) {
            xX = xX * - 1;
        }
        if (sX < 0) {
            sX = sX * - 1;
        }
        if (sY < 0) {
            sY = sY * - 1;
        }
        if (sy == ey && y == sy) {
            if (sx >= ex) {
                if (x <= sx && x >= ex) return true;
                else return false;
            }
            else if (ex >= sx) {
                if (x <= ex && x >= sx) return true;
                else return false;
            }
            else return false;
        }
        else if (sx == ex && x == sx) {
            if (sy >= ey) {
                if (y <= sy && y >= ey) return true;
                else return false;
            }
            else if (ey >= sy) {
                if (y <= ey && y >= sy) return true;
                else return false;
            }
            else return false;
        }
        else if (xX <= pmX && sX <= psmX && yY <= pmY && sY <= psmY) {
            if (y == (m * x) + b) return true;
            else return false;
        }
        else return false;
    }