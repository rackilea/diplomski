<div>
   <h:graphicImage id="root" value="#{managedBean.rootImage}" alt="image"/>
</div>

<div>
   <h:commandLink>
     <h:graphicImage value="images/image1.png" alt="image1"/>
     <f:setPropertyActionListener target="#{managedBean.rootImage}" value="images/image1.png" />
     <f:ajax event="action" render="root"/>  
   </h:commandLink>
</div>