component persistent="true" table="template"{

    property name="id"              column="templateID"      fieldtype="id"          generator="identity";
    property name="user"            fkcolumn="userID"        fieldtype="many-to-one" cfc="User";
    property name="lastModified"    column="lastModified";

}