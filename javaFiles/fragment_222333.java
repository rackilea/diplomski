Parse.Cloud.define("myFunction",function(req,res){
   var userId = req.params.userId; //params passed in Client code
   var myQuery = new Parse.Query(Parse.User);
   myQuery.equalTo("userId", userId);
   myQuery.find({
      success: function(results) {
          res.success(results.get("userName"));
      }
      error: function() {
         res.error("Failed !");
      }
   }

});