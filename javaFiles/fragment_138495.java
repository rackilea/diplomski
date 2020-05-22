ConvertCmd cmd = new ConvertCmd();

    IMOperation op = new IMOperation();
    op.addImage(imagePath);
    op.density(300);
    op.depth(8);
    op.strip();
    op.background("white");
    op.alpha("off");

    try {
        cmd.run(op);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (IM4JavaException e) {
        e.printStackTrace();
    }