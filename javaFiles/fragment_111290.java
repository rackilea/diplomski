@Test
    public void sourceToDestination() {
        List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add("dozer.xml");
        this.beanMapper = new DozerBeanMapper(mappingFiles);

        Source source = new Source();
        source.setField1("A");
        source.setField2("B");
        source.setField3("C");

        Destination dest = beanMapper.map(source, Destination.class);
        assertEquals("A", dest.getField1());
        assertEquals("B", dest.getField2());
    }

    @Test
    public void destinationToSource() {
        List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add("dozer.xml");
        this.beanMapper = new DozerBeanMapper(mappingFiles);

        Destination dest = new Destination();
        dest.setField1("A");
        dest.setField2("B");

        Source source = beanMapper.map(dest, Source.class);
        assertEquals("A", source.getField1());
        assertEquals("B", source.getField2());
        assertNull(source.getField3());
    }