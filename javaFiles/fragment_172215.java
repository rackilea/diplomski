function MySvcFunction(bothVar) {
 return $http.post('http://' + api_url + bothVar).then(
     function (response) {
          //manage success
     },
     function (error) {
          //manage error;
     });
}