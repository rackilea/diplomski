public class RepositoryFactory<T> {
    private Class<T> type;
    public RepositoryFactory(Class<T> type) {
        this.type = type;
    }
    public T getRepository(){
        if(type.isAssignableFrom(IQuestionRepository.class)){ //or type.equals(...) for more restrictive
            return new QuestionRepository();
        }
        ...
    }