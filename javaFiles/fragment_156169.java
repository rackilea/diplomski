class PutApronOnPreparation implements Preparation {
    private final String description;

    public PutApronOnPreparation(String description) {
        this.description = description;
    }

    @Override
    public getDescription() {
        return description;
    }
}