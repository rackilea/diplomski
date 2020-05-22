public static void main(String[] args) {
        try {
            File file = new File("AB.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(ABWrap.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ABWrap pojo = (ABWrap) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }