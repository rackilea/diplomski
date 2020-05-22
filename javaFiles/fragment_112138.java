final Map<ResourceType, Float> resources;

public ResourceManager() {
    this.resources = new EnumMap<>(ResourceType.class);
    for (ResourceType r : ResourceType.values()) {
        resources.put(r, 0f);
    }
}

public enum ResourceType {
    A,B,C
}

public void add(ResourceType type, float amount) {
    resources.merge(type, amount, Float::sum);
}