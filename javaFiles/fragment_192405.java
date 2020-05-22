ArgumentCaptor<ProducerRecord> captor = ArgumentCaptor.forClass(ProducerRecord.class);

    verify(mockKafkaProducer).send(captor.capture());

    ProducerRecord actualRecord = captor.getValue();
    assertThat(actualRecord.topic()).isEqualTo("mock topic");
    assertThat(actualRecord.key()).isEqualTo("...");
    ...