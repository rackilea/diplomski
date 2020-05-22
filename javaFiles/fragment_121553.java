public interface Parameter {
    public void process(Entity entity, Object obj, YamlConfiguration yml, String module);
}


// Somewhere else
Map<String, Parameter> parameters = ... // Initialise it with yours, allow the user to add their own

parameters.get(param.getKey()).process(entity, param.getValue(), yml, module);