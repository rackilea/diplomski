public void onPlayerInteract(PlayerInteractEvent event) {
    final Action action = event.getAction();
    Location l1 = null;
    Location l2 = null;
    if (action == Action.LEFT_CLICK_BLOCK){
        l1 = event.getClickedBlock().getLocation();
    } else if (action == Action.RIGHT_CLICK_BLOCK) {
        l2 = event.getClickedBlock().getLocation();
    }

    final Location l1Final = l1;
    final Location l2Final = l2;

    Thread t = new Thread() {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000*60*60);
                    Location maxx = l1Final.getX();
                    Location maxy = l1Final.getY();
                    Location maxz = l1Final.getZ();

                    Location minx = l2Final.getX();
                    Location miny = l2Final.getY();
                    Location minz = l2Final.getZ();


                    if(l1Final.getX() > l2Final.getX()){
                        // ...
                    }
                } catch (InterruptedException ie) {
                }
            }
        }
    };
    ...
}