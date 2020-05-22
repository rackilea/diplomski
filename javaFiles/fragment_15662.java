function calculate(value1, value2) {
    var dataObj = {val1 : value1, val2 : value2};
    $.ajax({
        url : 'calculator.jsp',
        dataType : 'text',
        data : dataObj,
        cache : false, // guarantees jsp is always called
        success: function(data) {
            var result = eval(data);
            var msg;
            if (result.errorMsg != '') {
                msg = result.errorMsg;
            } else {
                msg = result.val1 + " + " + result.val2 + " = " + result.sum + '\n';
                msg += result.val1 + " - " + result.val2 + " = " + result.difference + '\n';
                msg += result.val1 + " * " + result.val2 + " = " + result.product + '\n';
                msg += result.val1 + " / " + result.val2 + " = " + result.quotient;
            }
            alert(msg);
        }
   });
}