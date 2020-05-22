@SuppressWarnings("unchecked")
public List<ExamVO> getExams() {
    if(Exams == null) {
        exams = new ArrayList() {

            @Override
            public ExamVO set(int index, Object element) {
                // TODO if element is a String, 
                // call the verifyService.loadExam(Integer.decode(element));
                // to get the ExamVO and set that to element
                return (ExamVO)super.set(index, element);
            }
        };
    }
    return exams;
}