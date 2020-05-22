private ActionListener open() {

    return e ->{

        setSize(frame.getWidth() + 2, frame.getHeight());
        if(frame.getWidth() >= MAX_FRAME_WIDTH) {
            timer.stop();
        }
    };
}