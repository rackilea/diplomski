public static final String userHome = System.getProperty( "user.home" );
public static final File userMavenConfigurationHome = new File( userHome, ".m2" );
public static final String envM2Home = System.getenv("M2_HOME");
public static final File DEFAULT_USER_SETTINGS_FILE = new File( userMavenConfigurationHome, "settings.xml" );
public static final File DEFAULT_GLOBAL_SETTINGS_FILE =
    new File( System.getProperty( "maven.home", envM2Home != null ? envM2Home : "" ), "conf/settings.xml" );

//...

    SettingsBuildingRequest settingsBuildingRequest = new DefaultSettingsBuildingRequest();
    settingsBuildingRequest.setSystemProperties(System.getProperties());
    settingsBuildingRequest.setUserSettingsFile(DEFAULT_USER_SETTINGS_FILE);
    settingsBuildingRequest.setGlobalSettingsFile(DEFAULT_GLOBAL_SETTINGS_FILE);

    SettingsBuildingResult settingsBuildingResult;
    DefaultSettingsBuilderFactory mvnSettingBuilderFactory = new DefaultSettingsBuilderFactory();
    DefaultSettingsBuilder settingsBuilder =  mvnSettingBuilderFactory.newInstance();
    settingsBuildingResult = settingsBuilder.build(settingsBuildingRequest);

    Settings effectiveSettings = settingsBuildingResult.getEffectiveSettings();
    Map<String, Profile> profilesMap = effectiveSettings.getProfilesAsMap();
    Collection<RemoteRepository> remotes = new ArrayList<>(20);
    for (String profileName : effectiveSettings.getActiveProfiles())
    {
        Profile profile = profilesMap.get(profileName);
        List<Repository> repositories = profile.getRepositories();
        for (Repository repo : repositories)
        {
            RemoteRepository remoteRepo
                = new RemoteRepository(repo.getId(), "default", repo.getUrl());
            remotes.add(remoteRepo);
        }
    }