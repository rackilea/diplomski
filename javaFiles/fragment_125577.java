class GameBase
{
  @Inject private Injector injector;
  public <I extends Item> I createItem(Class<I> itemType){
    return injector.getInstance(itemType);
  }
}