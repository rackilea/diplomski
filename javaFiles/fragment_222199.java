$('#deleteModal').modal({
    ready: function(modal, trigger) {
        var button = $(trigger);
        var id = button.data('id');
        $('#modal-id').html(id);
        $('#idModalLink').attr("href", "/delete/" + id);
    }
});