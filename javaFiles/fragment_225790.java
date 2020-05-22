public interface PersistValidationGroup { }


  @NotBlank
  private String anotherString;

  @NotNull(groups={PersistValidationGroup.class})
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @NotNull(groups={PersistValidationGroup.class})
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;  

  @NotNull(groups={PersistValidationGroup.class})
  @Temporal(TemporalType.TIMESTAMP)
  private Date postedDate;