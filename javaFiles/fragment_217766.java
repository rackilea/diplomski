<pe:remoteCommand name="changeValor" 
    process="@this" 
    actionListener="#{BB.changeValor}" 
    global="false" 
    partialSubmit="true">
    <pe:methodSignature parameters="java.lang.String, java.lang.String, java.lang.String, java.lang.String" />
    <pe:methodParam name="valor" />
    <pe:methodParam name="fecha" />
    <pe:methodParam name="row" />
    <pe:methodParam name="i" />
</pe:remoteCommand>