$(':input[name=updatePassword]').click(function(e) { // <-- e implements Event
    e.preventDefault(); // <-- prevent the submit of the form
    var answerProceed = confirm("Do you wish to proceed with the changes?");
    if (answerProceed) {
        var form = $("form[name=form1]");
        // var form = e.currentTarget.form; you can do this
        // var form = this.form; or you can do this, "this" is implicit clicked element
        form.attr("action", '<s:url beanclass="c.c.i.c.app.profile.ui.ChangePasswordAction" event="update"/>');
        form.submit();
    }
    else {
        return false;
    }
});