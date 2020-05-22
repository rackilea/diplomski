function postForm() {
var form = $('<form method="POST" action="xyz"></form>');
$(document.body).append(form);
form.append('<input type="hidden" name="id" value="4"/>');
form.submit();
}