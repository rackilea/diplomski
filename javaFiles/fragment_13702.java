// This is the interface as it was defined:
public interface GlobalDashlet {        
    public void setSettings(Collection<? extends GlobalDashletSetting> settings);
}

public class Dashlet implements GlobalDashlet { 
    // Assume this was working: 
    public void setSettings(Collection<DashletSetting> settings) {

        // Then you could add a "DashletSetting" here:
        settings.add(new DashletSetting());
    }
}

// But someone who CALLED this method may not have given it
// a Collection<DashletSetting>, but maybe a collection
// like Collection<SpecialGlobalDashletSetting>:
Collection<SpecialGlobalDashletSetting> settings = ...;
GlobalDashlet dashlet = new Dashlet();

// Based on the method signature that was defined in the interface,
// this would be possible:
dashlet.setSettings(settings);

// Now, the "settings" collection WOULD contain a simple "DashletSetting",
// although it should only contain "SpecialGlobalDashletSetting" instances
// This would cause a ClassCastException sooner or later