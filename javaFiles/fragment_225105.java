class Label {

        private final Integer label;

        Label(Integer label) {
            this.label = label;
        }

        public Label differentLabel(Integer label){
            return new Label(label);
        }
    }