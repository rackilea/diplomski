@Persist
void save(MPart part)
{
   Map<String, String> persistedState = part.getPersistedState();

   persistedState.put("key for my value", "my value");
}