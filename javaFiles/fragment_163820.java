@Transactional
public void doSomething(String partId, Map<String, Object> model) {

    AssessmentPart assessmentPart = //laods a part with entity manager
    Assessment assessment = assessmentPart.getAssessment(); //Getting the assessments
    Hibernate.initialize(assesment.getAssesmentParts()); // Init collection
    model.put("assessmentParts", assessment.getAssessmentParts()); //adding all assessments parts into spring model map
}