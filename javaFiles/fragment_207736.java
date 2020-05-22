<af:iterator value="#{pageFlowScope.album.albumDetailCurrent}" id="i4" var="images" varStatus="parentStatus"
             rows="#{pageFlowScope.album.numberOfAlbumDetailRow}">
    <af:iterator value="#{images}" var="image" id="i5" varStatus="childStatus">
        <af:commandLink styleClass="btnPrint" id="cl10" actionListener="#{pageFlowScope.album.printImage}">
             <f:attribute name="parentStatus" value="#{parentStatus.index}"/>
             <f:attribute name="childStatus" value="#{childStatus.index}"/>
         </af:commandLink>
    </af:iterator>
</af:iterator>