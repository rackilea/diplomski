@BeforeClass
  public void setUp()
  {
    investigationResultStatusMapper = new InvestigationResultStatusMapper();
    investigationResultStatusNewEnum = PowerMockito.mock(InvestigationResultStatus.class);


    Whitebox.setInternalState(investigationResultStatusNewEnum, "name", "TEST");
    Whitebox.setInternalState(investigationResultStatusNewEnum, "ordinal", 9);

    InvestigationResultStatus[] investigationResultStatuses = Arrays
        .copyOf(InvestigationResultStatus.values(), InvestigationResultStatus.values().length + 1);
    investigationResultStatuses[investigationResultStatuses.length - 1] = investigationResultStatusNewEnum;

    PowerMockito.mockStatic(InvestigationResultStatus.class);

    PowerMockito.when(InvestigationResultStatus.values()).thenReturn(
        investigationResultStatuses);
  }

  /**
   * Test Method for {@link InvestigationResultStatusMapper#mapOmResultStatusToNovaResultStatus(InvestigationResultStatus)}
   * extend the InvestigationResultStatus enum for DEFAULT throw {@link IllegalArgumentException})
   */
  @Test(expectedExceptions = {
      IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "Unknown InvestigationResultStatus: TEST")
  public void testMapOmResultStatusToNovaResultStatus_whenHaveDefaultValue_thenThrowIllegalArgumentException()
  {
    investigationResultStatusMapper.mapOmResultStatusToNovaResultStatus(investigationResultStatusNewEnum);
  }