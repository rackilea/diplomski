jQuery.ajax({
   type: 'POST',
   url: "add/",
   data: person,
   dataType: "json",
   success: function(data) {
      alert("Person with ID "+data.person.id+"' added successfully");
   },
   error: function(XMLHttpRequest, textStatus, errorThrown) {
      var errorJSON = JSON.parse(XMLHttpRequest.responseText); //if this is JSON otherwise just alerting XMLHttpRequest.responseText will do

      var errors = "";
      for(var key in errorJSON) if(errorJSON.hasOwnProperty(key)) {
          errors += errorJSON[key] + "\n";
      }

      alert(errors);
   }
});