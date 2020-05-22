Runnable loop = new Runnable() {
    public void run() {
        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};