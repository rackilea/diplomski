Set<DemoClass> mySet = ...;
DemoClass demo = ...;
boolean wasInSet = mySet.remove(demo);
demo.setV1("new v1");
demo.setV2("new v2");
if (wasInSet) {
    set.add(demo);
}