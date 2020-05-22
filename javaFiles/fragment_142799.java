public void processWhatIs() throws IOException {
    final String filename = getArg("image");
    final File file = new File(filename);
    final Image img = ImageIO.read(file);
    final ImageMLData input = new ImageMLData(img);
    input.downsample(this.downsample, false, this.downsampleHeight,
            this.downsampleWidth, 1, -1);
    final int winner = this.network.winner(input);
    System.out.println("What is: " + filename + ", it seems to be: "
            + this.neuron2identity.get(winner));
 }