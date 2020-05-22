@Override
//here the messageReceived method is implemented
public void messageReceived(final ArrayList<DatenContainer> _Container) {                                               

    MainActivity.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {                                     
            ArrayList<DatenContainer> Container;

            synchronized (_Container) {
                Container = _Container;
            }

            try {                                       
                if (Container != null && !Container.isEmpty()) {

                for(int i = 0; i < Container.size(); i++) {

                        DatenContainer datenContainer = (DatenContainer)Container.get(i);

                        switch (datenContainer.get_ActSensor()) {                                               
                        case SPEED: 
                            edt_3.setText(datenContainer.get_Data());
                            break;
                        case COG:   
                            edt_4.setText(datenContainer.get_Data());
                            break;
                        default:
                            break;
                        }                                                   
                    }   
                } 
            }
            catch (Exception e) {
                Show_Toast(e.toString());
            }

            Container.clear();
        }
    });
}