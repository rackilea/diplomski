Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (view_pager.getCurrentItem() == dotsCount - 1) {
                        page = 0;
                    }
                    view_pager.setCurrentItem(page++, true);
                }
            });
        }
    }, 500, 5000);