interface Theme{
        void initialize();
        void handleEvent(AppEvent e);
    }

    class MyTheme implements Theme{
        public void initialize(){
            // init logic
        }

        public void handleEvent(AppEvent e){
            // handles the event
        }
    }