@Before
public void setUp() throws Exception {
    calendarDto = new ArrayList<CalendarDto>();
    test1 = new CalendarDto();
    test1.setStatus(TimesheetStatusEnum.APPROVED);
    test1.setMonth(1);
    test2 = new CalendarDto();
    test2.setMonth(2);
    test2.setStatus(TimesheetStatusEnum.REJECTED);
    calendarDto.add(test1);
    calendarDto.add(test2);

    MockitoAnnotations.initMocks(this)
}