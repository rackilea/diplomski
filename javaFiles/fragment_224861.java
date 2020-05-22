@JsonCreator
    public Parent(@JsonProperty("child_entity_id") Child childFromId, @JsonProperty("child_entity_selector") Child childFromSelector) {
        if (childFromId != null && childFromSelector != null) {
            throw new RuntimeException("Duplicated!");
        }

        this.child = (childFromSelector == null) ? childFromId : childFromSelector;
    }