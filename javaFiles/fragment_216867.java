if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
        camera.setDisplayOrientation(90);
        lp.height = previewSurfaceHeight;
        lp.width = (int) (previewSurfaceHeight / aspect);
    } else {
        camera.setDisplayOrientation(0);
        lp.width = previewSurfaceWidth;
        lp.height = (int) (previewSurfaceWidth / aspect);
    }