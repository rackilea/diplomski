public class Commands implements CommandExecutor {

    private MainClass plugin;

    public Commands(MainClass core) {
        this.plugin = core;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
your commands here
return true;
}
}