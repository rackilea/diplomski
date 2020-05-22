Properties props = new Properties();
props.setProperty("service.end-point", "http://127.0.0.1:8080");

CRest crest = new CRestBuilder()
                        .overrideDefaultConfigWith(props)
                        .build();