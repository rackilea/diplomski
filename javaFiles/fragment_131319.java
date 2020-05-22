public int pixelsOfWantedInches(double inches, Activity act) {
        DisplayMetrics dm = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int dens=dm.densityDpi;
        int pixels = (int)(inches * (double) dens);

        return pixels;
    }


int wantedPixels = pixelsOfWantedInches(1.7, this);