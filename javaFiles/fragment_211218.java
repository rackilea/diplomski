@Autowired
Map<Environment, BaseUserService> serviceMap;

...

for (Entry<Environment, BaseUserService> e : serviceMap.entrySet()) {
    if (config.environments.contains(e.getKey())) {
        userList.addAll(e.getValue().getUserList(username,configValue,dateOfBirth));
    }
}