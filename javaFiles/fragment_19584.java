// Declare that the provider of DefaultSettings is a singleton
bind(DefaultSettings.class).in(Singleton.class);

// Bind the providers of the interfaces FirstSettings and SecondSettings
// to the provider of DefaultSettings (which is a singleton as defined above)
bind(FirstSettings.class).to(DefaultSettings.class);
bind(SecondSettings.class).to(DefaultSettings.class);