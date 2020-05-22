public class IntegerToQueConverter implements Converter<String, QuestionType> {

    @Autowired
    private QuestionTypeService questionTypeService;

    @Override
    public QuestionType convert(String questionType) {
        return questionTypeService.findOne(questionType);
    }
}