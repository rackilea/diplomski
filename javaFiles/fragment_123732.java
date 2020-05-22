if ($(this).find('option:selected').attr("name")==='edit') {
        window.location.href="edit_product.jsp?code="+$('.edit_select option[name=edit]:selected').val();
        return;
} else if($(this).find('option:selected').attr("name")==='delete')               {
        window.location.href="delete_product.jsp?code="+$('.edit_select option[name=delete]:selected').val();
        return;
}