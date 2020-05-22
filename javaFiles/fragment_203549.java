<c:forEach var="item" items="#{cc.attrs.dm.wrappedData}">
  <li>
    <p:commandLink process="@this"
        actionListener="#{cc.actionListener(item)}" update="#{cc.attrs.update}">
      <h:outputText value="#{item.round.name}"/>
    </p:commandLink>
  </li>
</c:forEach>