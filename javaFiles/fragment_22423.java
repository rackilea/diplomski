public abstract class Team{
    protected abstract Logger getLogger();

    protected void updateProgress(){
        getLogger().info("Updating progress!");
        // do something to update the progress
    }
}