// items is an array of strings sent from the client side
for (var i = 0; i < items.length; i++) {
  (function(item_name) {    
    // For each item, find an existing one
    Item.findOne({'name': item_name }, function(err, item) {
      // If not already existing, add to database.
      if (!item) {         
        var new_item = new Item();
        new_item.name = item_name;

        new_item.save(function(err) {
          if (err) throw err;
        });
      }
    });
  })(items[i]);
}