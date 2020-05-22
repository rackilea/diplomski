public boolean setSize(java.awt.Rectangle source, java.awt.Rectangle dest) {

        setVideoSize((int) source.getX(), (int) source.getY(),
                (int) source.getWidth(), (int) source.getHeight(),
                (int) dest.getX(), (int) dest.getY(), (int) dest.getWidth(),
                (int) dest.getHeight());

        return true;

    }

    private void setVideoSize(int x, int y, int width, int height, int x2,
            int y2, int width2, int height2) {
        // TODO Auto-generated method stub

    }