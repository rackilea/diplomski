$("#range").change(function() {
    var rdArray = ${rd};

    alert("A Range was entered");

    var floatVal = parseFloat($("#range").val());
    var rangeFound = false;
    var rdSize = rdArray.length;
    var index = 0;
    while (index < rdSize && !rangeFound)
    {
        var rangeObject = rdArray[index++];
        if (floatVal >= rangeObject.startRange && floatVal <= rangeObject.endRange)
        {
            rangeFound = true;
            $('#testName').val(rangeObject.rangeName);
        }
    }

});