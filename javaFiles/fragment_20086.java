.enrich(e -> {
            ContentEnricher contentEnricher =
                    e.requestChannel(subChannel())
                            .requestPayload(Message::getPayload)
                            .propertyExpression("fooId", "payload.id"))
                            .get().getT2();
            contentEnricher.setErrorChannel(enricherErrorChannel());
        })