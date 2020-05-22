@Autowired
private BotCommandListener botListener;

@PostConstruct
public void init(){    
    JDA jda = new JDABuilder(AccountType.BOT)
        .setToken(TOKEN)
        .addEventListener(botListener)
        .build(); 
       // ...    
}