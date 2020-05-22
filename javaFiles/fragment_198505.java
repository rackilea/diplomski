public void Program
{
    public Mode mode;

    public static void main(String[] args)
    {
        mode = Config.getMode();
        mode.run();
    }
}