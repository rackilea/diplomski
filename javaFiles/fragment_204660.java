@Slf4j
public class ItemVerificationSkipper implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {

            StringBuilder errorMessage = new StringBuilder();
            errorMessage
                    .append("Unexpected exception ")
                    .append(exception.toString())
//                    .append(ExceptionUtils.getStackFrames(exception))
                    .append("\n");
            log.error("{}", errorMessage.toString());
            return true;
    }

}