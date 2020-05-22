_items[] depthSort (_parent){
  add _parent to _items[];

  get _children of _parent sorted by desired attribute;

  for every _item in _children
      depthSort(_item);
}