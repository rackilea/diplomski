$('#delete-project-btn').on('click', function() {
    if (cur != null) {
        alert(cur);
        if(window.confirm('sure?')) {
            $.ajax({
                url : '/index?projectId='+cur,
                type : 'delete',
                dataType : 'text'

            });
         }
    } 

})