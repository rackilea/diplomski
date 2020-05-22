public int getX() {
            double dbl = topLeft.getX().doubleValue();
            return (int) dbl;
        }

        public int getY() {
            double dbl = topLeft.getY().doubleValue();
            return (int) dbl;
       }

        public void setX(int x) {
            topLeft.setLocation(x, topLeft.getY());
        }

        public void setY(int y) {
            topLeft.setLocation(topLeft.getX(), y);
        }