public abstract class Superclass {
        protected SomeField someField;
        /**
        * DO NOT use this constructor! Just don't!
        */
        @SuppressWarnings( "unused" )
        private Superclass() {
        }

        public Superclass( SomeField someField ) {
            this.someField = someField;
        }

        public abstract void update( float delta );
        public abstract void render();
    }