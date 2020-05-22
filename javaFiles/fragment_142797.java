private void processNetwork() throws IOException {
    System.out.println("Downsampling images...");

    for (final ImagePair pair : this.imageList) {
        final MLData ideal = new BasicMLData(this.outputCount);
        final int idx = pair.getIdentity();
        for (int i = 0; i < this.outputCount; i++) {
            if (i == idx) {
                ideal.setData(i, 1);
            } else {
                ideal.setData(i, -1);
            }
        }

        final Image img = ImageIO.read(fc.getFile());
        final ImageMLData data = new ImageMLData(img);
        this.training.add(data, ideal);
    }

    final String strHidden1 = getArg("hidden1");
    final String strHidden2 = getArg("hidden2");

    this.training.downsample(this.downsampleHeight, this.downsampleWidth);

    final int hidden1 = Integer.parseInt(strHidden1);
    final int hidden2 = Integer.parseInt(strHidden2);

    this.network = EncogUtility.simpleFeedForward(this.training
            .getInputSize(), hidden1, hidden2,
            this.training.getIdealSize(), true);
    System.out.println("Created network: " + this.network.toString());
}