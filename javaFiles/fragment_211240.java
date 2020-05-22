behaviour1.addValueChangeListener(
    new ValueChangeListener() {
        @Override
        public void valueChange(Property.ValueChangeEvent event){
            Notification.show("Value changed:",    String.valueOf(behaviour1.getValue()), Notification.Type.TRAY_NOTIFICATION);
            if (behaviour1.getValue().equals("end-dx6")) {
                System.out.print("else if");
                hop1.setVisible(true);
                out1.setVisible(true);
                nextHop.setVisible(true);
                outGoing.setVisible(true);
            }
        }
    }
);