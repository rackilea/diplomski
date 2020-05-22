<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
          xmlns:f="http://java.sun.com/jsf/core"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
          xmlns:cust="http://xmlns.oracle.com/adf/faces/customizable"
          xmlns:pe="http://xmlns.oracle.com/adf/pageeditor">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <f:view>
        <af:document id="d1" title="#{applicationScope.navigationContext.currentNavigationModel.currentSelection.title}">
            <af:form id="f1" usesUpload="true">
                <af:pageTemplate viewId="/oracle/webcenter/portalapp/pagetemplates/WF_Template.jspx"
                         value="#{bindings.pageTemplateBinding}" id="pt1">
                    <f:facet name="content">
                        <pe:pageCustomizable id="pageCustomizable1" inlineStyle="width:968px;">
                            <f:facet name="editor">
                                <pe:pageEditorPanel id="pep1"/>
                            </f:facet>
                            <af:panelGroupLayout layout="vertical" id="pgl1"> 
                                ---
                                <af:region value="#{bindings.albumtaskflow1.regionModel}" id="albumrg"/>
                                ---
                            </af:panelGroupLayout>
                        </pe:pageCustomizable>
                    </f:facet>
                </af:pageTemplate>
            </af:form>
        </af:document>
    </f:view>
</jsp:root>