// remove "this.itemPromise = " and just have the code below
this.http.get('http://localhost:8080/dy/get-goal?id=' + params['id'])
   .toPromise()
   .then(res => res.json())
   .then(data => {
      this.item = data[0];
   })