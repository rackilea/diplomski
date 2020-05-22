@Test
public void test() {
    // given
    BotEnvironments botEnvironments = new BotEnvironments("bid", 1, "env");
    BotEnvironments botEnvironments1 = new BotEnvironments("bid", 1, "env1");
    BotVersion botVersion = new BotVersion("bid", 1, "json", Set.of(botEnvironments, botEnvironments1));
    Bot bot = new Bot("bid", Set.of(botVersion));
    botRepository.save(bot);

    // when
    Bot savedBot = botRepository.findAll().get(0);
    savedBot.getVersions().iterator().next().getEnvironments().remove(savedBot.getVersions().iterator().next().getEnvironments().iterator().next());
    botRepository.save(savedBot);

    // then
    assertEquals(1, botEnvironmentsRepository.findAll().size());
}