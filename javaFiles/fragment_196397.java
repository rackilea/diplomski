Movie result = MovieCreator.build("input.mp4");
    // do something with the file
    Container out = new DefaultMp4Builder().build(result);
    MovieHeaderBox mvhd = Path.getPath(out, "moov/mvhd");
    mvhd.setMatrix(Matrix.ROTATE_180);
    out.writeContainer(new FileOutputStream("result.mp4").getChannel());