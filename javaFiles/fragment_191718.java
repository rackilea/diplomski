from("file:data/source?noop=true")
                        .to("validator:books.xsd")
                        .split()
                        .tokenizeXML("book")
                        .unmarshal(jaxb)
                        .to("jpa:com.labs.Book")
                        .process(new Processor() {
                            public void process(Exchange exchange)
                                    throws Exception {
                                //here it is
                                int Id = exchange.getIn().getBody(Book.class).getId();
                            }
                    });