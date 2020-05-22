unmarshaller.setEventHandler(new ValidationEventHandler() {
        @Override
        public boolean handleEvent(ValidationEvent ve) {
            System.out.println(ve.getMessage());
            return true;
        }
    });