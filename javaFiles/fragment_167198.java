private abstract class Command {
    int m_percentage;       
    Command(int percentage) {
        m_percentage = percentage;
    }       
    int getPercentage() {
        return m_percentage;
    }
    abstract void executeCommand();
};

private class CommandA extends Command {        
    CommandA(int percentage) {
        super(percentage);
    }
    @Override
    public void executeCommand() {
        //Execute Command A
    }       
}

private class CommandB extends Command {        
    CommandB(int percentage) {
        super(percentage);
    }
    @Override
    public void executeCommand() {
        //Execute Command B
    }

}