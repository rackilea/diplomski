Reconcile reconcile = new Reconcile();
reconcile.start_date = LocalDateTime.of(2018, 4, 8, 11, 2, 44);
reconcile.end_date = LocalDateTime.of(2018, 11, 8, 11, 2, 44);
reconcile.page = 1;

JAXBContext jaxbContext = JAXBContext.newInstance(Reconcile.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
marshaller.marshal(reconcile, System.out);