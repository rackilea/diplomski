function saveCommentData(seq_no, index) {
    var activecheck = confirm('change message save?');
    var data = {}
    data.seq_no = seq_no;
    var comment = $("#comment" + index).val();
    data.body = comment
    if (activecheck == true) {
        updateStatus(data);
    } else {
        location.reload();
    }
}