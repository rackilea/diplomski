@Autowired
private static BotCommandListener botListener;

public static void main(String[] args)  {
    SpringApplication.run(DethBotApplication.class, args);
    try {
        JDA jda = new JDABuilder(AccountType.BOT)
            .setToken(TOKEN)
            .addEventListener(botListener)
     //...
    }