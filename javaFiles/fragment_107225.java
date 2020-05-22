package com.mycompany.myproduct;

@Plugin(name = "FabLookup", category = StrLookup.CATEGORY)
public class BetterLookup extends AbstractLookup {
    @Override
    public String lookup(final LogEvent event, final String key) {
        return com.mycompany.SomeClass.getValue(key);
    }
}