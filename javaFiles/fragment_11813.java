import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OptionsAdapter extends XmlAdapter<AdaptedOptions, Options> {

    @Override
    public Options unmarshal(AdaptedOptions v) throws Exception {
        if("default_options".equals(v.name)) {
            DefaultOptions options = new DefaultOptions();
            options.setName(v.getName());
            options.setDefaultPort(Integer.valueOf(v.map.get("default_port")));
            options.setLogLevel(v.map.get("log_level"));
            return options;
        } else {
            CustomOptions options = new CustomOptions();
            options.setName(v.getName());
            options.setCompatibility(v.map.get("compatibility"));
            options.setMemory(v.map.get("memory"));
            return options;
        }
    }

    @Override
    public AdaptedOptions marshal(Options v) throws Exception {
        AdaptedOptions adaptedOptions = new AdaptedOptions();
        adaptedOptions.setName(v.getName());
        if(DefaultOptions.class == v.getClass()) {
            DefaultOptions options = (DefaultOptions) v;
            adaptedOptions.map.put("default_port", String.valueOf(options.getDefaultPort()));
            adaptedOptions.map.put("log_level", options.getLogLevel());
        } else {
            CustomOptions options = (CustomOptions) v;
            adaptedOptions.map.put("compatibility", options.getCompatibility());
            adaptedOptions.map.put("memory", options.getMemory());
        }
        return adaptedOptions;
    }

}