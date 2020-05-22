cartWhisky = JSON.parse(localStorage.getItem("shoppingCart"));
    var newArray = [];
    var i = 0;
    for (i in cartWhisky) {
        newArray[i] = cartWhisky[i].name + "_" + cartWhisky[i].quantity+"_"+cartWhisky[i].photo;
        i++;
    }
    $.ajax({
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        type: "POST",
        url: '/buySuccessfulWhisky',
        data:

        JSON.stringify(newArray),
        success: function (msg) {
            window.location.href = "warehouseWhisky";