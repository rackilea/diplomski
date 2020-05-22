@Reference(
 cardinality = ReferenceCardinality.MULTIPLE,
 policy = ReferencePolicy.DYNAMIC,
 policyOption = ReferencePolicyOption.GREEDY
 )
protected void setService(Service service, Map<String, Object> properties) {
   String type = MapUtil.getString(properties, "type");
   _services.put(type, service);
}