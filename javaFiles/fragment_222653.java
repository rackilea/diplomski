...
public class MailFolder {

@Field(type = FieldType.String, index = not_analyzed)
private String id;

@Field(type = FieldType.String, index = not_analyzed)
private String name;

@Field(type = FieldType.String, index = not_analyzed)
private String icon;

@Field(type = FieldType.Boolean, index = not_analyzed)
private boolean system;

@Field(type = FieldType.Nested, ignoreFields = {"children"})
private List<MailFolder> children;
...