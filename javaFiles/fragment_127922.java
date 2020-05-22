@Override
public void execute(FunctionContext context) {
  RegionFunctionContext rfc = (RegionFunctionContext) context;
  Region<EmpId, PDXInstance> employee = PartitionRegionHelper.getLocalPrimaryData(rfc.getDataSet());
  Region<DeptId, PDXInstance> department = PartitionRegionHelper.getLocalPrimaryData(rfc.getDataSet());
  int count = 0;
  Map<PdxInstance, PdxInstance> results = new HashMap<>();
  for (Region.Entry<EmpId, PDXInstance> e : employee.entrySet()) {
    PdxInstance dept = department.get(e.getValue().get("deptId"));
    results.put(e.getValue(), dept);
    if (count == 500) {
      context.getResultSender().sendResult(results);
      results.clear();
      count = 0;
    }
  }
  context.getResultSender().lastResult(results);
}