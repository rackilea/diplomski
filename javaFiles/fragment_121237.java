function calc() {
var transport = new Thrift.Transport("/service");
var protocol  = new Thrift.Protocol(transport);
var client    = new pruebaClient(protocol);


var workbench = Math.random()*1000;
var div = document.getElementById('deltat');


    try {

      result = client.number(1);
      div.innerHTML = div.innerHTML + '\nReady';

    } catch(ouch){

      $('#result').val("ERROR");
      $('#result').css('color', 'red');
    }
}