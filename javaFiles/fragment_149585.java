@Mapper
public interface CallRecordsMapper {

    CallRecordsMapper INSTANCE = Mappers.getMapper(CallRecordsMapper.class);

    @Mapping(source="callRecordOperators",target = "operators")
    CallRecordsDto callRecordsToCallRecordsDto(CallRecords callRecords);

    @Mapping(target = "callRecordsId", source = "callrecord.id")
    @Mapping(target = "operatorId", source = "operator.id")
    @Mapping(target = "operatorName", source = "operator.name")
    @Mapping(target = "currentTime", source = "startTime")
    CallRecordOperatorsDto callRecordOperatorsToDto(CallRecordOperators source);
}