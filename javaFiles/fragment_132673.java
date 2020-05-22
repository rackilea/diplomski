$('#manualModePopupSave').click(function(e) {
    //Use this...
    e.preventDefault();

    var userno=$('#userno').val();

    ....

    //or this.
    return false;
});