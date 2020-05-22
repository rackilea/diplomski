public enum MapCases {
    FLOOR {
        @Override
        public Block makeBlock() {
            return new Floor();
        }
    },
    WALL {
        @Override
        public Block makeBlock() {
            return new Wall();
        }
    },
    ROCK {
        @Override
        public Block makeBlock() {
            return new Rock();
        }
    };

    public abstract Block makeBlock();
}