new Thread(new Runnable() {      
@Override
public void run()
{
  try{
    ZooKeeperServerMain zk = new ZooKeeperServerMain()
    zk.runFromConfig(config1);
  }catch(Exception e){
    e.printStackTrace();
  }        
}
}).start();