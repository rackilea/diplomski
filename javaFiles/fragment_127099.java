static class LastImageHolder
    private BufferedImage lastImage;

    public synchronized BufferedImage get() {
        return lastImage;
    }

    public synchronized BufferedImage set(BufferedImage lastImage) {
        this.lastImage = lastImage;
    }
}

private LastImageHolder lastImageHolder = new LastImageHolder();