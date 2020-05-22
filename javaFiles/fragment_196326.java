jaxbUnmarshaller.setEventHandler(new ValidationEventHandler() {

        @Override
        public boolean handleEvent(ValidationEvent event) {
            System.out.println(event.getMessage());
            return true;
        }

    });