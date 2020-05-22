/**
     * Handles the {@code --release} option.
     *
     * @param additionalOptions a predicate to handle additional options implied by the
     * {@code --release} option. The predicate should return true if all the additional
     * options were processed successfully.
     * @return true if successful, false otherwise
     */
    public boolean handleReleaseOptions(Predicate<Iterable<String>> additionalOptions) {
        String platformString = options.get(Option.RELEASE);

        checkOptionAllowed(platformString == null,
                option -> reportDiag(Errors.ReleaseBootclasspathConflict(option)),
                Option.BOOT_CLASS_PATH, Option.XBOOTCLASSPATH, Option.XBOOTCLASSPATH_APPEND,
                Option.XBOOTCLASSPATH_PREPEND,
                Option.ENDORSEDDIRS, Option.DJAVA_ENDORSED_DIRS,
                Option.EXTDIRS, Option.DJAVA_EXT_DIRS,
                Option.SOURCE, Option.TARGET,
                Option.SYSTEM, Option.UPGRADE_MODULE_PATH);

        if (platformString != null) {
            PlatformDescription platformDescription =
                    PlatformUtils.lookupPlatformDescription(platformString);

            if (platformDescription == null) {
                reportDiag(Errors.UnsupportedReleaseVersion(platformString));
                return false;
            }

            options.put(Option.SOURCE, platformDescription.getSourceVersion());
            options.put(Option.TARGET, platformDescription.getTargetVersion());

            context.put(PlatformDescription.class, platformDescription);

            if (!additionalOptions.test(platformDescription.getAdditionalOptions()))
                return false;

            JavaFileManager platformFM = platformDescription.getFileManager();
            DelegatingJavaFileManager.installReleaseFileManager(context,
                                                                platformFM,
                                                                getFileManager());
        }

        return true;
    }