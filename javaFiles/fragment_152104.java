try {
            File file = new File("/path/to/your/file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(YouRootClass.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setEventHandler(
                    new ValidationEventHandler() {
                        public boolean handleEvent(ValidationEvent event ) {
                            throw new RuntimeException(event.getMessage(),
                                    event.getLinkedException());
                        }
                    });
            YouRootClass pojo = (YouRootClass) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }