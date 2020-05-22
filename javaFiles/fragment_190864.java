public class MineFactory extends Installation {
    private final Resources cost;

    public MineFactory(Resources cost) {
      this.cost = cost.clone();
    }

    @Override
    public Result build(Resources availableResources) {    
      if (!availableResources.remove(cost)) {
        return Result.empty();
      }
      return Result.mines(2);    
    }    
}