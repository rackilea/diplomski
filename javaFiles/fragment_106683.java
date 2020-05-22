enum Employee {
    SENIOR {
        @Override
        public int salary() {
            return 60;
        }
    },
    JUNIOR {
         @Override
         public int salary() {
            return 40;
         }
    };

    public abstract int salary ();
}