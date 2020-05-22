function inviteUser(req,res) {

pool.getConnection(function(err,connection){
    if (err) {
      connection.release();
      res.json({"code" : 100, "status" : "Error in connection database"});
      return;
    }   

    console.log('connected as id ' + connection.threadId);

    connection.query("select req.body.userId from user",function(err,rows){
        connection.release();
        if(!err) {
            //ADD Group id to the user access the id with req.body.groupId
            res.json(rows);
        }           
    });

    connection.on('error', function(err) {      
          res.json({"code" : 100, "status" : "Error in connection database"});
          return;     
    });
  });
}

function acceptInvitation(req,res){

pool.getConnection(function(err,connection){
    if (err) {
      connection.release();
      res.json({"code" : 100, "status" : "Error in connection database"});
      return;
    }   

    console.log('connected as id ' + connection.threadId);

    connection.query("select req.body.groupId from groups",function(err,rows){
        connection.release();
        if(!err) {
            //ADD user id to the group access the id with req.body.userId
            res.json(rows);
        }           
    });

    connection.on('error', function(err) {      
          res.json({"code" : 100, "status" : "Error in connection database"});
          return;     
    });
  });
}
}

app.get("/users/invite",function(req,res){-
    inviteUser(req,res);
});

app.get("/users/accept",function(req,res){-
    acceptInvitation(req,res);
});