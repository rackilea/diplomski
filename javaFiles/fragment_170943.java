public enum DefaultIdManager implements IdManager {
    ...
    ANY {
        @Override
        public Long getNextId(final TinkerGraph graph) {
            return unique random number
        }
    }
    ...
}