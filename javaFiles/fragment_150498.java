@Mapper(componentModel = "spring")
public interface ITeamResponseToDtoMapper {

    TeamResponseDTO toDto(TeamResponse teamResponse);

    List<NameAndTypeDTO> natListToDTO(List<NameAndType> natList);

    NameAndTypeDTO nameAndTypeToDTO(NameAndType nameAndType);

}