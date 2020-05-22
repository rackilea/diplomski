private static final class ApplicationIncomingDto {

    private final String name = null;
    private final ApplicationType type = null;
    private final String packageName = null;
    private final Integer otpExpiry = null;
    private final String senderId = null;
    private final Integer otpLength = null;
    private final Long requestPerIp = null;
    private final List<String> secretKey = null;
    private final String signature = null;

    private Application application() {
        final Application application = new Application();
        application.setName(name);
        application.setType(type);
        application.setPackageName(packageName);
        application.setOtpExpiry(otpExpiry);
        application.setSenderId(senderId);
        application.setOtpLength(otpLength);
        application.setRequestPerIp(requestPerIp);
        application.setSecretKey(secretKey.stream().collect(Collectors.joining()));
        application.setSignature(signature);
        return application;
    }

}