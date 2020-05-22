<ui:repeat value="..." var="repeatedVar">
  <h:inputText id="newTxt" value="#{repeatedVar}" >
     <f:attribute name="unique_id" value="#{repeatedVar.uniqueId}" />
  </h:inputText>
</ui:repeat>
<h:commandButton actionListener="#{managedBean.someMethod}" ...