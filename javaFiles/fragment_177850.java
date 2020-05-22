PrimeFaces.widget.MyTerminal = PrimeFaces.widget.Terminal.extend({

init : function(cfg) {
    this._super(cfg);
    commandsList = window[this.jq.attr('completion')];
},