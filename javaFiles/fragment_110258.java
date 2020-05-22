App.ApplicationAdapter = DS.RESTAdapter.extend({
    host: App.host,
    namespace : App.namespace,
    ajax: function(url, method, hash) {
        hash = hash || {}; // hash may be undefined
        hash.crossDomain = true;
        hash.xhrFields = { // import line added
            withCredentials: true    // import line added       
        };
        console.log('DEBUG: inside RESTAdapter ajax call');
        return this._super(url, method, hash);
    }
});