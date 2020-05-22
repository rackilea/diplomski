new EventHandler<ActionEvent>() {
        @Override // <- notice the annotation, it overrides from the interface.
        public void handle(ActionEvent event) {
                System.out.print("Hello World !!");
        }
    }