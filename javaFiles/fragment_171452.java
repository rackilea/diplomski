from("timer:simpleTimer1?period=2000").process((exchange) -> {
            List<TestPOJO> names = new ArrayList<>();
            names.add(new TestPOJO("f1"));
            names.add(new TestPOJO("f2"));
            exchange.getOut().setBody(names);
        }).split(simple("${body}")).to("stream:out");