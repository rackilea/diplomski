<div ng-model="selected.packages"
     ng-repeat="item in selected.warehouse.packages">

  <input type="checkbox"
         ng-checked="exists(item, selected)"
         ng-click="toggle(item, selected)"> {{ item.name }}
  <p> </p>
  {{ item.firstName }} {{ item.user.lastName }}
</div>