_process: function (snap) {
    var dat = snap.val();
    var key = snap.key();

    // get your query string
    var q = dat.query.query_string.query;

    // build your ES query
    var q1 = {"query":{"match":{"_all":q}}};

    if (this._assertValidSearch(key, dat)) {
        // Perform (a very simple) ElasticSearch query
        this.esc.search({
            index: dat.index,
            type: dat.type,
            // add options 
            from : dat.options.from,
            size : dat.options.size,
            // add ES Query
            body : q1
        }, function (error, response) {
            if (error) {
                this._reply(key, {error: error, total: 0});
            } else {
                this._reply(key, response);
            }
        }.bind(this));
    }
},