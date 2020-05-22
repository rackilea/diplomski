this._on( this.input, {
    autocompleteselect: function( event, ui ) {
        $.ajax({
        type: 'POST',
        url: 'AjaxServlet',
        dataType : 'json',
        data: { comboboxvalue : ui.item.value  }
        });
        ui.item.option.selected = true;
        this._trigger( "select", event, {
            item: ui.item.option
        });
    },

    autocompletechange: "_removeIfInvalid"
});