callback : function(data) {
  data = JSON.parse(data);
  for(var i in data.res){
      console.log(i); //key
      console.log(data.res[i]); //value  
  }
}