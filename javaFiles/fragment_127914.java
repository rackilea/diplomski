$("#department").autocomplete({
    source: "getdept.jsp",
    minLength: 4,
    select: function(event, result) { 
        $("#hiddenfield").val(result)
    }
});