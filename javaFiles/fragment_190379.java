class ExtraFields {

    private String createdBy;
    //Getters omitted
}

public interface DepToTripEventMapperApi {

    //Your mappings
    Tripevent DepDtoToTripEvent(Dep depDto, String regUserId, Long messageId, Vessel vessell, List<Triplog>tripLogs, @Context ExtraFields extra);

    //Your mappings
    TdfiFishgear geaToFishGear(NonFarGea gea, @Context ExtraFields extra);

    @AfterMapping
    default void afterMapping(@MappingTarget TdfiFishgear fea, @Context ExtraFields extra) {
        fea.setCreatedBy(extra.getCreatedBy());
    }
}