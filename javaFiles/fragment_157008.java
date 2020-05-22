@Mapper(uses = { CommentMapper.class })
public interface TicketMapper {
    TicketDTO mapToTicketDTO(Ticket ticket);

    @IterableMapping(elementTargetType = TicketDTO.class)
    List<TicketDTO> mapToTicketDTOList(Collection<Ticket> tickets);

    TicketWithCommentsDTO mapToTicketWithCommentsDTO(Ticket ticket);

    @IterableMapping(elementTargetType = TicketWithCommentsDTO.class)
    List<TicketWithCommentsDTO> mapToTicketWithCommentDTOList(Collection<Ticket> tickets);
}