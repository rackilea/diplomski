<%
    //////////////////////////////////
    /// Check if class has been Aliased by XStream
    def alias = jClass.qualifiedName;
    def actualClass = jClass.type;

    if (jClass.isAnnotationPresent(
                        com.thoughtworks.xstream.annotations.XStreamAlias.class)) {
        com.thoughtworks.xstream.annotations.XStreamAlias xstreamAlias = actualClass.getAnnotation(com.thoughtworks.xstream.annotations.XStreamAlias.class);
        alias = xstreamAlias.value();
    }
%>
[Bindable]
[RemoteClass(alias="${alias}")]
public class ${jClass.as3Type.name} extends ${jClass.as3Type.name}Base {<%