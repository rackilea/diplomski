DateFormat dateFmt = new SimpleDateFormat("whatever date format you want");
URIComponentsBuilder.fromHttpUrl("httpL//example.com")
                    .queryParam("prop1", a.prop1)
                    .queryParam("prop2", a.prop2)
                    .queryParam("date1", dateFmt.format(a.date1))
                    .queryParam("date2", dateFmt.format(a.date2))
                    .queryParam("prop3", a.objB.prop3)
                    .queryParam("prop4", a.objB.prop4)
                    .build();