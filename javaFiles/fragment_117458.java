class MovingLabel {

        private ResultPane resultPane; // Declare it as instance variable

        public MovingLabel() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ...
                    resultPane = new ResultPane(); // Initialize the instance variable
                    ...
                }
         } 
  }