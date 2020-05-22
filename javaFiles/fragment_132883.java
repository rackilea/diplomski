@PostConstruct
void createPart(MPart part)
{
   Map<String, String> persistedState = part.getPersistedState();

   String myValue = persistedState.get("key for my value");
}