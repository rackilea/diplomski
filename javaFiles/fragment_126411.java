public abstract class CommandBase {

    public abstract String getName();

    public String getUsage() {
        return "/" + this.getName();
    }

}