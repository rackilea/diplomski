public SecretBind createBind(Secret secret) {
    SecretFile file = SecretFile.builder()
                                .name(secret.secretSpect().name())
                                .uid("0")
                                .gid("0")
                                .build();
    SecretBind bind = SecretBind.builder()
                                .secretName(secret.secretSpec().name())
                                .secretId(secret.id())
                                .file(file)
                                .build();
    return bind;
}