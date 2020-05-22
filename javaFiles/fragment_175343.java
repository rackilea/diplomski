public class BetterNamedMapConverter extends NamedMapConverter {

    public BetterNamedMapConverter(Mapper mapper, String entryName, String keyName, Class keyType, String valueName, Class valueType,
            boolean asAttributes, ConverterLookup lookup) {
        super(mapper, entryName, keyName, keyType, valueName, valueType, asAttributes, asAttributes, lookup);
    }

}