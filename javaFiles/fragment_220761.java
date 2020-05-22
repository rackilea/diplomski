@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
@JoinColumns({
        @JoinColumn(name = "botId", referencedColumnName = "botId"),
        @JoinColumn(name = "version", referencedColumnName = "version")
})
private Set<BotEnvironments> environments = new LinkedHashSet<>();