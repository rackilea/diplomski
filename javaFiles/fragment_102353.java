class Container {
    private Rows rows;

    public Rows getRows() {
        return rows;
    }

    public void setRows(Rows rows) {
        this.rows = rows;
    }
}

class Rows {
    @JsonProperty("row")
    private List<Row> rows;

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}

class Row {
    @JsonProperty("column")
    private List<Column> columns;

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getColumns() {
        return columns;
    }
}

class Column {
    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("@name")
    private String name;

    @JsonDeserialize(using = JavaTypeDeserializer.class)
    @JacksonXmlProperty(isAttribute = true, localName = "class")
    @JsonProperty(value = "@class")
    private Class<?> classType;

    @JacksonXmlProperty(isAttribute = true)
    @JsonProperty("@type")
    private String type;

    @JacksonXmlText
    @JsonProperty("$")
    private String content;

    public void setName(String name) {
        this.name = name;
    }

    public void setClassType(Class<?> classType) {
        this.classType = classType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

}