<ui:repeat value="#{backingbeanName. fruitLis}" var="field" >
              <tr>
                      <td> <h:outputLabel value="Fruit Name"/></td>

                     <td>   <h:outputLabel  value=":"></h:outputLabel> </td>



               <td> <h:outputLabel value="#{field}"/></td>

               </tr>
            </ui:repeat>