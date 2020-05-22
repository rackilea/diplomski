$.getJSON("/country", {latitude: <latitude>, longitude: <longitude>}, function(data) { 

        if (data != null) {
          for(key in data){
           var lat = data[latitude];
           var long = data[longitude];
          }
        }
     });