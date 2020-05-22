public abstract class MediaResourceMapperDecorator implements MediaResourceMapper {

    private final MediaResourceMapper delegate;

    public MediaResourceMapperDecorator(MediaResourceMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    MediaResourceDTO mediaResourceToMediaResourceDTO(MediaResource mediaResource) {
        // Let MapStruct do the basic mapping:
        final MediaResourceDTO dto = this.delegate.mediaResourceToMediaResourceDTO( mediaResource );

        // Then load and add the file to the DTO:
        dto.setResourceFile( loadMyFile( mediaResource.getOriginalMediaFileName() );

        return dto;
    }
}