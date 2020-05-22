@Component(
   property = {
     CommandProcessor.COMMAND_SCOPE + "=species",
     CommandProcessor.COMMAND_FUNCTION + "=create",
     CommandProcessor.COMMAND_FUNCTION + "=list",
     CommandProcessor.COMMAND_FUNCTION + "=delete"
   },
   service = CreateSpeciesCommand.class
 )
 public class CreateSpeciesCommand {
   @Reference
   ConfigurationAdmin configurationAdmin;

   public Configuration create(String speciesId) throws Exception {
     Configuration c = configurationAdmin.createFactoryConfiguration( "species.pid", "?");
     Hashtable<String,Object> d = new Hashtable();
     d.put("id", speciesId);
     c.update( d );
     return c;         
   }

   public Configuration[] list() throws Exception {
     return configurationAdmin.
        listConfigurations( "(service.factoryPid=species.pid)");
   }

   public boolean delete(String id) throws Exception {
     Configuration[] list = configurationAdmin.
        listConfigurations( "(&(service.factoryPid=species.pid)(id="+id+"))");
     if ( list == null) {
        return false;
     }
     for ( Configuration c : list ) {
        c.delete();
     }
     return true;
   }
}