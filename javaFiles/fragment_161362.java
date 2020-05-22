public static Job getJobOutputKeyAvroSchema(Schema avroSchema) {
    Job job;

    try {
        job = new Job();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    AvroJob.setOutputKeySchema(job, avroSchema);
    return job;
}