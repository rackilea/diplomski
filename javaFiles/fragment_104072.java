@Component
public class AddFormValidator implements Validator {

    @Autowired
    NewsRepository newsRepository;       

    public boolean supports(Class<?> clazz) {
        return AddForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        AddForm addForm = (AddForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "title.empty", "Title must not be empty.");
        String title = addForm.getTitle();
        if ((title.length()) > 30) {
            errors.rejectValue("title", "title.tooLong",
                    "Title must not more than 16 characters.");
        }

        New new = newsRepository.findByTitle(title);
        // New already exist
        if (new != null) {
            errors.rejectValue("title", "title.alreadyExist",
                    "New title already exist");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content",
                "content.empty", "Content must not be empty.");
        String content = addForm.getContent();
        if ((content.length()) > 10000) {
            errors.rejectValue("content", "content.tooLong",
                    "Content must not more than 10K characters.");
        }

    }
}