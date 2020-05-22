enum FilePackSubclassOption {

    TYPE_A() {
        @Override
        public FilePack createFilePack() {
            return new FilePackTypeA();
        }

        @Override
        public String getName() {
            return "Type A";
        }
    };

    public abstract FilePack createFilePack();
    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}