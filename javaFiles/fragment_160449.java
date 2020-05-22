function(head, req){
  var filter = function(key){ 
    if (!req.query.q){
      return key; // list all
    }
    if (!req.query.q.match('^[\d-]+$'){
      return; // don't allow regex injections
    }
    var match = key.match('.*' + req.query.q + '.*');
    if (match) return match[0];
  }
  start({'headers': {'Content-Type': 'text/plain'}});
  var num = null;
  while(row=getRow()){
    num = filter(row.key);
    if (num){
      send(num + '\n');
    }
  }
}