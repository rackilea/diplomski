function dataToServer() {
    var array = [];
    var str1 = $('#source').val();
    var str2 = $('#target').val();

    array = [str1 , str2];

    return JSON.stringify(array);
}