<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
          xmlns:f="http://java.sun.com/jsf/core"
          xmlns:h="http://java.sun.com/jsf/html"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <f:view>
        <af:document id="d1" title="Print">
            <af:resource type="javascript" source="/js/js/jquery-1.7.1.min.js"/>
            <af:form id="f1">
                <af:image source="http://#{facesContext.externalContext.request.serverName}/file/#{pageFlowScope.albumPrint.image.docName}&amp;Rendition=Web" id="i3" shortDesc="#{pageFlowScope.albumPrint.image.title}"/>
            </af:form>            

            <af:resource type="javascript">
                $(document).ready(function () {                    
                    window.print();
                });
            </af:resource>            
        </af:document>
    </f:view>
</jsp:root>