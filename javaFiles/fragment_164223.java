private ProfileDAO profileDAO;
private String[] temp;
    private LoadingCache<String, List<Profile>> loadingCache = CacheBuilder.newBuilder()
            .refreshAfterWrite(5, TimeUnit.MINUTES)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build(
                    new CacheLoader<String, List<Profile>>() {
                        @Override
                        public List<Profile> load(String key) throws Exception {
                            logger.info("Running method to retrieve from database");
                            temp = key.split("\\|");
                            String instance = temp[0];
                            String name = temp[1];
List<Profile> profiles= profileDAO.getProfileByFields(id, name);
                            if (profiles == null || profiles.isEmpty()) {
                                List<Profile> nullValue = new ArrayList<Profile>();
                                logger.info("Unable to find a value.");
                                return nullValue;
                            }
                            logger.info("Found a value");
                            return profileDAO.getProfileByFields(id, name);
                        }
                    }
            );

public List<Profile> getProfileByFields(String id, String name) throws Exception {
        String key = id.toLowerCase() + "|" + name.toLowerCase()
        return loadingCache.get(key);
    }