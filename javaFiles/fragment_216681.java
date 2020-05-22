final Map<String, Object> aProps = BeanUtils.describe(a);
final Map<String, Object> bProps = BeanUtils.describe(b);
aProps.keySet().retainAll(bProps.keySet());
for (Entry<String, Object> entry : aProps.entrySet()) {
    BeanUtils.setProperty(b,entry.getKey(), entry.getValue());
}