function ExampleCtrl(FileSaver, Blob) {
  var vm = this;

  vm.val = {
    text: 'Hey ho lets go!'
  };

  vm.download = function(text) {
    var data = new Blob([text], { type: 'text/plain;charset=utf-8' });
    FileSaver.saveAs(data, 'text.txt');
  };
}

angular

      .module('fileSaverExample', ['ngFileSaver'])
      .controller('ExampleCtrl', ['FileSaver', 'Blob', ExampleCtrl]);