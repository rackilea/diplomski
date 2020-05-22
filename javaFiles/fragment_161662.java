from("timer://theTimerName?pattern=yyyy-MM-dd HH:mm:ss&fixedRate=true&period=10000")
            .process(new Processor() {
                public void process(Exchange msg) throws Exception {
                    String firedTime = msg.getIn().getHeader("firedTime", String.class);
                    LocalDateTime ldtnow = LocalDateTime.parse(firedTime,formatter2);
                    LocalDateTime sldt = ldtnow.minusSeconds(5); 
                    LocalDateTime eldt = ldtnow.plusSeconds(60); 
                    String pollingQuery = "sql:select * from myTable where updateTimestamp between '" + sldt.format(formatter) + "' and '" + eldt.format(formatter) + "'?dataSource=myDatasourceBean";
                    msg.getIn().setBody(pollingQuery);
                }
            })
            .toD("${body}")   //the constructed sql statement                
            .split(body())
            .convertBodyTo(java.lang.String.class, "UTF-8")
            ...