// spinner type
Spinner<Integer> spinner;
// value type (in valueFactory):
ObjectProperty<Integer> valueProperty;
// value type in bean:
IntegerProperty valXProperty;
// to be bindeable to spinner's value, needs to be wrapped
// into ObjectProperty<Integer>
// intuitively ... WRONG!
valueProperty.bindBidirectional(bean.valXProperty().asObject());