fx.EditableTextTableCell = function () {
  var cell;
  if(!fx.EditableTextTableCell.Class) {
    fx.EditableTextTableCell.Class = Java.extend(fx.JsTextTableCell, {
      updateItem: function (item, isEmpty) {
        if(!isEmpty){
          cell.super$setText(item);
        }
      }
    });
  }

  cell = new fx.EditableTextTableCell.Class();

  return cell;
};