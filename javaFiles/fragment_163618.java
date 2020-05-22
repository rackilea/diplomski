@Mock private TeamRepository mockTeamRepository; 
@Mock private PersonRepository mockPersonRepository;

@Before 
public void setUp() { 
    MockitoAnnotations.initMocks(this); 
    mapper = new ModelMapper(); 
    teamService = new TeamService(mockTeamRepository, mapper); 
    personService = new PersonService(mockPersonRepository, mapper);
}

@Test
public void shouldAddPersonToTeam(){
    Team team = new Team(1L, "TestCase1", "Description1", "Krakow", 12);
    Person person = new Person(1L, "jan", "mucha", "krakow", "email1@onet.com", "Programing", "Developer");

    doReturn(team).when(mockTeamRepository).getOne(1L);
    doReturn(person).when(mockPersonRepository).getOne(1L);

    teamService.createTeam(mapper.map(team, TeamDto.class));
    personService.addPerson(mapper.map(person, PersonDto.class));

    teamService.addPersonsToTeams(team.getId(), person.getId());

    verify(mockTeamRepository).save(team);
    verify(mockPersonRepository).save(person);
}