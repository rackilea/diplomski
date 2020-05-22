public class MyJexlArithmetic extends JexlArithmetic {

        public MyJexlArithmetic(boolean lenient) {
            super(lenient);
        }

        private void checkInterrupted() {
            if (Thread.interrupted()) throw new CancellationException();
        }

        @Override
        public boolean equals(Object left, Object right) {
            checkInterrupted();
            return super.equals(left, right); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object add(Object left, Object right) {
            checkInterrupted();
            return super.add(left, right);
        }
    }