WindowManager.getDefault().addWindowSystemListener(new WindowSystemListener() {

        @Override
        public void beforeLoad(WindowSystemEvent wse) {
        }

        @Override
        public void afterLoad(WindowSystemEvent wse) {
            // at this point all windows are opened
        }

        @Override
        public void beforeSave(WindowSystemEvent wse) {
        }

        @Override
        public void afterSave(WindowSystemEvent wse) {
        }
    });