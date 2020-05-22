$scope.downloadCsv = function () {
    console.log("downloadCsv");
    var fileName = "test.csv";
    var a = document.createElement("a");
    document.body.appendChild(a);
    XxxxxxServiceCSV.downloadCsv().then(function (result) {
        console.log("downloadCsv callback");
        var file = new Blob([result.data], {type: 'application/csv'});
        var fileURL = URL.createObjectURL(file);
        a.href = fileURL;
        a.download = fileName;
        a.click();
    });
};