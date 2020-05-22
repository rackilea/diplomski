public enum BuildingType {
    farm() {
        public Building createBuilding() {
            return new Farm();
        }
    },
    shop() {
        public Building createBuilding() {
            return new Shop();
        }
    },
    house() {
        public Building createBuilding() {
            return new House();
        }
    };

    public abstract Building createBuilding();
}