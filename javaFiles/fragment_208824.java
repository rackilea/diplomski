BusyPainter painter = new BusyPainter();
    ActionListener l = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int frame = busyPainter.getFrame();
            frame = (frame+1)%busyPainter.getPoints();
            busyPainter.setFrame(frame);
        }

    };
    Timer timer = new Timer(delay, l);
    AbstractHighlighter hl = new PainterHighlighter(HighlightPredicate.NEVER, painter);
    table.getColumnExt().addHighlighter(hl);

    // on a change that should toggle the busy-ness on/off
    if (on) {
         hl.setHighlightPredicate(HighlightPredicate.ALWAYS);
         timer.start();
    } else {
         hl.setHighlightPredicate(HighlightPredicate.NEVER);
         timer.stop(); 
    }