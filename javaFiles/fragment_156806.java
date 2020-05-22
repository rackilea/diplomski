public class Data
   private Map<String, Object> attributes

public class Command
   private Map<String, Data> data;

public class Device
   private Map<String, Command> commands;

// in main, etc
for (Entry<String, Command> commandEntry : device.getCommandEntries())
{
  for (Entry<String, Data> dataEntry : commandEntry.getValue().getDataEntries())
  {
    for (Entry<String, Object> attributeEntry : dataEntry.getValue().getAttributeEntries())
       // do something
  }
}