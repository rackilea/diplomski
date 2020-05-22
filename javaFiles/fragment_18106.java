handleInvoice(e) {
  e.preventDefault()
  var item = this.state.item;
  var lines = item.order;
  var request = require('superagent');
  var apiBaseUrl = "api/Invoice";
  var req = request.get(apiBaseUrl);
  req.query({
    item: item.id
  });

  req.on('progress', event => {
    // set state for the current progress percentage
    this.setState({ progress: event.percent });
  });

  req.end(function (err, res) {
    if (err) {
      alert(" error" + err);
      confirmAlert({
        message: 'Invoice is not prepared properly.....',
        confirmLabel: 'Ok',
      });
    }
    else {
      window.location = 'api/Invoice?item=' + item.id, '';
      element.click();
    }
  });
}