public class AccessClass extends JFrame
{
    final AccessMain experiment;

    public AccessClass(AccessMain experiment)
    {
        this.experiment = experiment;
    }

    public String getSubjectNumber(){
        return experiment.getSubjectNumber();
    }
}