db.node_info.find({ 
  nodes : { 
    $elemMatch : { 
      mac_address : { $ne : "-" } 
    } 
  }
})