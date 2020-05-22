StringBuilder msg = new StringBuilder();

for (int i = 2; i < args.length; i++)
{
    msg.append(args[i] + " ");
}
Util.messagePlayer(player, msg.toString);