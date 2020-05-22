axis.setTickLabelFormatter(new StringConverter<Number>() {
        private SimpleDateFormat format = new SimpleDateFormat("dd.MM HH:mm");

        @Override
        public String toString(Number object) {
            return format.format(new Date((long) object));
        }

        @Override
        public Number fromString(String string) {
            // TODO
            return null;
        }
    });