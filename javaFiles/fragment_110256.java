Ember.$.ajaxTransport( function( options, originalOptions, jqXHR ) {
  var xdr;

  return {
    send: function( _, completeCallback ) {
      xdr = new XDomainRequest();
      xdr.onload = function() {
        if (xdr.contentType.match(/\/json/)) {
          options.dataTypes.push("json");
        }

        completeCallback(200, 'success', { text: xdr.responseText } );
      };
      xdr.onerror = xdr.ontimeout = function() {
        completeCallback(400, 'failed', { text: xdr.responseText } );
      }

      xdr.open(options.type, options.url);
      xdr.send(options.data);
    },
    abort: function() {
      if(xdr) {
        xdr.abort();
      }
    }
  };
});