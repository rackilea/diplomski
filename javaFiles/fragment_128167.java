public abstract Process implements Runnable {

        private final Properties props;
        private final String processName;

        public Process(String processName, Properties props) {
            this.processName = processName;
            this.props = props;
        }

        //this can also be a non abstract (reusable) method 
        // to eliminate boiler plate code (if any)
        public abstract void shutdown();
    }