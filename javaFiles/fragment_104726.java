public class Updater
{
    public Updater(List<IUpdateHelper> helpers)
    {
        helpers = new ArrayList<UpdateHelper>();
        this.helpers.add(helpers);
    }
    public void update()
    {
        for (IUpdateHelper helper : helpers)
        {
            helper.performHelp();
        }
    }

    protected List<IUpdateHelper> helpers;
}

public class UpdaterCommon extends Updater
{
    public UpdaterCommon()
    {
        helpers.add(new UpdateHelperA());
        ... // Etc.
    }
}

/*
 * This uses inheritance for common helpers, but it could just as well use
 * delegation. Also, this assumes that order of invocation for each helper 
 * doesn't matter.
 */
public class UpdaterOne extends UpdaterCommon {...}

interface IUpdateHelper
{
    public void performHelp();
}
public class UpdateHelperA implements IUpdateHelper {...}