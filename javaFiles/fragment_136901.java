function getNestedQuestions(parentQuestionId) {
    $.ajax({
        type : "GET",
        url : '/nestedQuestions',
        data : {
            parentQuestion : parentQuestionId
        },
        success : function(data) {
            // for each question in data, show it...
        },
        error : function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        }
    });
}