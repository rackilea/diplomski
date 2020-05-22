Schema schema = SchemaBuilder.record("TestFile")
            .namespace("com.example.kafka.data.ingestion.model")
            .fields()
            .requiredLong("date")
            .requiredInt("counter")
            .requiredString("mc")
            .endRecord();

GenericRecord entry1 = new GenericData.Record(schema);
entry1.put("date", 1L);
entry1.put("counter", 2);
entry1.put("mc", "3");

// producer.send(new ProducerRecord<>(topic, entry1);