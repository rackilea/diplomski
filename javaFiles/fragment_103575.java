String parseCommand = "vlan4094";
if (parseCommand.startsWith("vlan"))
{
   int v = Integer.parseInt(parseCommand.substring(4));
   if (v >= 1 && v <= 4094)
      /* do stuff */
}