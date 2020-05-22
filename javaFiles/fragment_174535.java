public class Jaxb2Marshaller ... {
    /**
     * Set the schema resource to use for validation.
     */
    public void setSchema(Resource schemaResource) {
        this.schemaResources = new Resource[] {schemaResource};
    }

    /**
     * Set the schema resources to use for validation.
     */
    public void setSchemas(Resource... schemaResources) {
        this.schemaResources = schemaResources;
    }
}