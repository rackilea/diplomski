EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {

                PaintEvent pe = (PaintEvent) event;

                String type = "";
                if (pe.getID() == PaintEvent.PAINT) {
                    type = "PAINT";
                } else if (pe.getID() == PaintEvent.PAINT_FIRST) {
                    type = "PAINT_FIRST";
                } else if (pe.getID() == PaintEvent.PAINT_LAST) {
                    type = "PAINT_LAST";
                } else if (pe.getID() == PaintEvent.UPDATE) {
                    type = "UPDATE";
                }

                System.out.println(type + "; pe.UpdateRec = " + pe.getUpdateRect() + "; pe.component = " + pe.getComponent());

            }
        }, AWTEvent.PAINT_EVENT_MASK);

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
});