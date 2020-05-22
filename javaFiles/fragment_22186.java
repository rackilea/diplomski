<af:componentDef var="attrs" componentVar="component">
      <af:panelGroupLayout id="time" layout="horizontal">
         <af:outputText id="ot1" label="#{attrs.customLabel}"/>
      </af:panelGroupLayout>
      <af:xmlContent>
         <component xmlns="http://xmlns.oracle.com/adf/faces/rich/component">
            <display-name>weirdLabel</display-name>
            <attribute>
               <attribute-name>customLabel</attribute-name>
               <attribute-class>java.lang.String</attribute-class>
            </attribute>
            <component-extension>
               <component-tag-namespace>component</component-tag-namespace>
               <component-taglib-uri>http://www.example.com/components</component-taglib-uri>
            </component-extension>
         </component>
      </af:xmlContent>
   </af:componentDef>