public enum EmployeeTableColumn {
    NAME {
        @Override
        public Object getData(EmployeeData data) {
            return data.getName();
        }
    },
    DESCRIPTION {
        @Override
        public Object getData(EmployeeData data) {
            return data.getDescription();
        }
    },
    CONTRIBUTION {
        @Override
        public Object getData(EmployeeData data) {
            return data.getAddress();
        }
    };

    public abstract Object getData(EmployeeData data);
}