exports.showEvent = functions.https.onRequest((req, res) => {
    let prov = "";
    return admin.database().ref('requests').once('value', (snapshot) => {
      snapshot.forEach(function(ds) {
          var okk = ds.child("value").val() / 100000000;
          prov += ds.child("wallet").val()+ ", " + parseFloat(okk).toFixed(8) + "\n";
        ds.ref.remove();
      });
        res.send(prov);
     });
});