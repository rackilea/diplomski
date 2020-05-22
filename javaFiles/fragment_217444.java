<tr ng-repeat="obj in list"> 
    <td> 
           <input id="{{obj.name}}" type="checkbox" value="{{obj.name}}" 
           checklist-model="checkboxes" ng-checked="selection.indexOf(obj.name) > -1" 
           ng-click="toggleSelection(obj.name)" />
   </td>
</tr>