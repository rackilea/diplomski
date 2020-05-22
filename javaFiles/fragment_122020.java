class TopDtoForm {
  @NotEmpty
  private String topVar;
  @Valid
  private List<DownDto> downVarList;
  //getter and setter
}

class DownDto {
  private Long id;
   @NotEmpty
  private String name;
  //getter and setter
}