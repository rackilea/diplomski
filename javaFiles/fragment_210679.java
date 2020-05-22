public enum EntityType {

    ARROW {
        @Override
        public EntityItem makeEntity(
                int id,
                float x,
                float y,
                float z,
                float rotation,
                int mapId
        ) {
            // uses subclass
            return new EntityArrow(id, x, y, z, rotation, mapId);
        }
    },
    CIRCLE {
        @Override
        public EntityItem makeEntity(
                int id,
                float x,
                float y,
                float z,
                float rotation,
                int mapId
        ) {
            // uses base class
            return new EntityItem(this, id, x, y, z, rotation, mapId);
        }
    };

    public abstract EntityItem makeEntity(
            int id,
            float x,
            float y,
            float z,
            float rotation,
            int mapId
    );
}