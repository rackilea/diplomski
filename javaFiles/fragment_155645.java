@Override
public RepeatStatus execute(StepContribution contribution, 
                            ChunkContext chunkContext) throws Exception {

    // why not using println? because it makes testing harder, *nix and
    // windows think different about new line as in \n vs \r\n
    System.out.print("Hello World! "+message);

    return RepeatStatus.FINISHED;
}