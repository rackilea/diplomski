Unmarshaller unmarshaller = jc.createUnmarshaller();
    unmarshaller.setEventHandler(new ValidationEventHandler() {
        @Override
        public boolean handleEvent(ValidationEvent event) {
            return true;
        }

    });