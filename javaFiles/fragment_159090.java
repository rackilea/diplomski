function addEnter(textareaId) {
    var textarea = document.getElementById(textareaId);
    textarea.value += '\n';
    textarea.focus();
}

function addBackspace(textareaId) {
    var textarea = document.getElementById(textareaId);
    textarea.value = textarea.value.substring(0, textarea.value.length - 1);
    textarea.focus();
}