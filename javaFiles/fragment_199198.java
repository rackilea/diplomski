class Photograph { 

    private int maxTakes;
    private String[] titles;
    private int numPhotosTaken;

    public Photograph(int maxTakes) {
        this.maxTakes = maxTakes;
        this.titles = new String[maxTakes];
        numPhotosTaken = 0;
    }

    public boolean setTitle(String title) {
        if (this.numPhotosTaken < this.titles.length) {
            this.titles[numPhotosTaken] = title;
            numPhotosTaken++;
            return true;
        }
        else {
            return false;
        }
    }
}