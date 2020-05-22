jQuery("#dialog-form").dialog({ 
  autoOpen: false,
  height: 300,
  width: 350,
  modal: true,
  buttons : {
    "Search" : function() {
      jQuery.ajax({type : 'POST',
        url : '<s:url action="part" method="find"/>'
      }); 
    } 
  }
});