public Runnable r = new Runnable() {

        @Override
        public void run() {
            value = value + 10;
            svgCanvas.evaluate("setlevel(" + value + ",'Text')");
        }
    };