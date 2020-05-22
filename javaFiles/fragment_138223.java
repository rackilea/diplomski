@Autowired
    private Neo4jTemplate template;

    @Transactional
    @Test
    public void saveEvent()
        {

        User user = new User();
        MyEvent event = new MyEvent();

        EventResponse response = new EventResponse();
        response.user = user;
        response.event = event;

        this.template.save(user);
        this.template.save(event);
        this.template.save(response);

        }