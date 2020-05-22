IObservableValue observeSelectionAgeSpinnerObserveWidget = WidgetProperties.selection().observe(ageSpinner);
IObservableValue ageResultObserveValue = PojoProperties.value("age").observe(comp.result);
dataBindingContext.bindValue(observeSelectionAgeSpinnerObserveWidget, ageResultObserveValue, null, null);
//
IObservableValue observeSingleSelectionGenderCombo = ViewerProperties.singleSelection().observe(genderCombo);
IObservableValue genderResultObserveValue = PojoProperties.value("gender").observe(comp.result);
dataBindingContext.bindValue(observeSingleSelectionGenderCombo, genderResultObserveValue, null, null);