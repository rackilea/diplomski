$.ajax({
                type: "POST",
                url: "<SERVLET_PATH>",
                contentType: "application/json",
                cache: false,
                data: that.parsedEstimator,
                xhrFields: {responseType: "blob"},
                success: function (data) {
                    a = document.createElement('a');
                    var binaryData = [];
                    binaryData.push(data);
                    a.href = window.URL.createObjectURL(new Blob(binaryData, {type: "application/pdf"}));
                    a.download = "Estimation.pdf";
                    a.style.display = 'none';
                    document.body.appendChild(a);
                    a.click();
                }
            });