public class ModifierSetup {
    private String pipelineId;
    private String ElasticHostURL;

    // all args constructor
}

// inside your CSVDataModifier
private ModifierSetup setup;

public CSVDataModifier(Path src, /*Path dest, */ String b_id, String p_id, String elasticUrl) {
    this.src = src;
    this.blockId = b_id;
    this.setup = new ModifierSetup(p_id, elasticUrl);
}

// ...

if ((resultLine = marker.createResultLine(columnName, values[col], buf, this.setup)) != null) {

// ...

public abstract String[] createResultLine(String columnName, String value, String[] buf, ModifierSetup modifierSetup);