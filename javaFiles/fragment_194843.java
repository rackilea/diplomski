myValidatorcv = new CustomValidator() {

        @Override
        protected boolean condition(Object value) {
            try {
                Integer.parseInt(value.toString());
                return true;
            } catch (NumberFormatException) {
                return false;
            }
        }
};