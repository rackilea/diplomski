class JobSerializer extends StdSerializer<Salary> {

    public JobSerializer() {
        this(Salary.class);
    }

    public JobSerializer(Class<Salary> t) {
        super(t);
    }

    @Override
    public void serialize(Salary value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("id", value.jobClassCd + value.payGrade + value.jobGroup);
        jgen.writeStringField("label", value.jobClassTitle + "( " + value.jobClassCd + value.payGrade + ") " + value.jobGroup);

        jgen.writeStringField("pay_grade_description_link", "payGrade");
        jgen.writeStringField("job_type", value.sectionToDisplay);
        jgen.writeStringField("mou", value.mou);
        jgen.writeStringField("mou_description", value.mouDescription);
        jgen.writeStringField("special_notes", value.specialNotes);
        jgen.writeStringField("salary_range_min_step_message", value.salaryRangeMinStepMessage);

        List<String> jobs = Arrays.asList(value.step1, value.step2, value.step3, value.step4, value.step5, value.step6, value.step7,
                value.step8, value.step9, value.step10, value.step11, value.step12, value.step13, value.step14,
                value.step15, value.step16, value.step17, value.step18, value.step19, value.step20);
        jgen.writeObjectField(value.rateType, jobs);

        jgen.writeEndObject();

    }
}