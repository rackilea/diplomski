class Pair {
        private final Entity entity;
        private final boolean success;

        private Pair(Entity entity, boolean success) {
            this.entity = entity;
            this.success = success;
        }

        public Entity getEntity() {
            return entity;
        }

        public boolean isSuccess() {
            return success;
        }
    }