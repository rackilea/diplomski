app.post("/act/add",function (req,res) {

        var addActif = JSON.parse(req.body); //parse object
        console.log("params: "+addActif);

        try {
            http.get(url+"/Add",addActif, function (response) { // delete '+'
                var dataJson ='';
                response.on('data',function(data){
                    dataJson += data;
                });
                response.on('end',function(){
                    try
                    {
                        var addAct = JSON.parse(dataJson);
                    }
                    catch(err) {
                        console.log('erreur de retourner l\'actif  -->', +err);
                    }
                res.json(addAct);
            });
        });
    }
    catch(e) {
        console.log("erreur d'ajouter les info d'actif -->", +e);
    }
});