myketUpdater.connectService(new MyketCustomCallback() {
            @Override
            public void myketServiceComplete(Boolean isServiceConnected) {
                Toast.makeText(MainActivity.this, isServiceConnected.toString(), Toast.LENGTH_SHORT).show();
            }
        });