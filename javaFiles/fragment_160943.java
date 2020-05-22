public class LogoListener  {

        /**
         * A static reference to this.
         */
        private static LogoListener listener;

        /**
         * Represents the objects to be notified by the listener.
         */
        private static List<Follower> followers;

        /**
         * Create a simple listener to be used by one "notifying"
         * object, and "followers" objects.
         *
         */
        private LogoListener() {
            followers = new ArrayList<Follower>();
            listener = this;
        }

        /**
         * Method to be used by the "notifying" object, to
         * notify followers.
         */
        public void notifyFollowers() {

            for(Follower follower : followers){
                follower.changed("Logo changed");
            }

            System.out.println("Logo changed");

        }

        /**
         * Get the listener instance, or create one if it does not exist.
         *
         * @return the listener
         *              
         */
        public static LogoListener getListener() {

            if(listener == null) {
                listener = new LogoListener();
            }
            return listener;
        }

        /**
         *
         * @param follower
         *       <br>Not null.
         * @throws
         *      <br>IllegalArgumentException if <code>follower</code> is   null.
         */
         public void addFollower(Follower follower) {

            if(follower == null ) {
                throw new
                    IllegalArgumentException("Follower should not be null");
            }

            followers.add(follower);
        }

    }