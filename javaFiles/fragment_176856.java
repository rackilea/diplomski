public class PinboardService implements IPinboardService{
  private IPinboardEntryDAO pinboardEntryDao;

  ...

  public void setPinboardEntryDAO(IPinboardEntryDAO dao){
     this.pinboardEntryDao = dao;
  }

  public IPinboardEntryDAO getPinboardEntryDAO(){
    ...
  }

  ...
}

public class PinboardEntryDAO implements IPinboardEntryDAO{
   ...
}