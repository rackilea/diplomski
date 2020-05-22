public interface AssigmentFileMapper {

    AssigmentFileDTO assigmentFileToAssigmentFileDTO(AssigmentFile assigmentFile);

    AssigmentFile assigmentFileDTOToAssigmentFile(AssigmentFileDTO assigmentFileDTO);

    @IterableMapping(qualifiedByName="mapWithoutData")
    List<AssigmentFileDTO> assigmentFilesToAssigmentFileDTOs(List<AssigmentFile> assigmentFiles);

    List<AssigmentFile> assigmentFileDTOsToAssigmentFiles(List<AssigmentFileDTO> assigmentFileDTOs);

    @Named("mapWithoutData")
    @Mapping(target = "data", ignore = true)
    AssignmentFileDto mapWithouData(AssignmentFile source)

}