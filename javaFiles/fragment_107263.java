public List<ExampleClient> nodes;
@Override
public void takeLeadership(CuratorFramework client) throws Exception
{
    // we are now the leader. This method should not return until we want to relinquish leadership
    for(ExampleClient e : nodes){
      if(this != e)
        e.doWork();
    }
    ...