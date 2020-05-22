// contains all DatacenterEnum except ourLocation
Set<DatacenterEnum> remoteSet =
    EnumSet.complementOf(EnumSet.of(ourLocation));
// as a List, if you want
List<DataceterEnum> remoteList =
    new ArrayList<>(remoteSet);