[
  {
    "operation": "shift",
    "spec": {
      "data": {
        // Ex. send the first data item to 
        //    2015-02-26.clothes[] 
        //    where we want clothes to always be an array 
        //    even if it only got one value assigned to it.
        "*": "@(0,date).@(0,category)[]"
      }
    }
  }
]