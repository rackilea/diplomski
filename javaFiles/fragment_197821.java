public interface Pipeline<T extends Stage> {
     public void execute(T stage);
}

public interface BookPipeline extends Pipeline<BookStage> {
     @Override
     public void execute(BookStage stage);
}