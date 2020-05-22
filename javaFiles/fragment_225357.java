try (StreamEx<MyEntity> stream = StreamEx.of(myEntities)) {
            stream.groupRuns((prev, next) -> recordCounter.incrementAndGet() % myApplicationProperties.getBatchSize() != 0)
                    .forEach((chunk) -> {
                        if (chunk.size() != 1) {
                            jmsTemplate.convertAndSend(chunk);
                        } else {
                            jmsTemplate.convertAndSend(chunk.get(0));
                        }
                    });
        }