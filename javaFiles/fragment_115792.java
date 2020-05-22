@Service
public class TestService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    public void addQuestion(QuestionDTO dto) {
        Tag tag = null;
        User user = null;
        Question question = null;

        Set<Tag> tags = null;

        tag = tagRepository.findById(dto.getTag());

        tags = new HashSet<>();
        tags.add(tag);

        user = userRepository.findById(dto.getUser());

        question = new Question();
        question.setTag(tags);
        question.setUser(user);
        question.setId(dto.getId());
        question.setBody(dto.getBody());
        question.setTitle(dto.getTitle());
        question.setViewCount(dto.getViewCount());
        question.setAnswerCount(dto.getAnswerCount());
        question.setDateCreated(dto.getDateCreated());

        questionRepository.save(question);

    }
}