public class ListPredicate implements Predicate<String,Object>{

private Set<String> switchIds = null;

public ListPredicate(Set<String> switchIds) {
    this.switchIds = switchIds;
}

@Override
public boolean apply(Entry<String, Object> mapEntry) {
    Container container = (Container) mapEntry.getValue();
    for(String switchId : container.getFrameSwitchIdList()) {
        if(switchIds.contains(switchId)) {
            return true;
        }
    }
    return false;
}