@Override
public void execute(FunctionContext context) {
  RegionFunctionContext rfc = (RegionFunctionContext) context;
  Region r = PartitionRegionHelper.getLocalDataForContext(rfc);
  ...
}