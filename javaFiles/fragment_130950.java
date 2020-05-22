$('#downloadFile').click(function () {
                            var specialElementHandlers = 
                            function (element,renderer) {
                            return true;
                            }
                            var doc = new jsPDF();
                            doc.fromHTML($('#target').html(), 15, 15, {
                            'width': 170,
                            'elementHandlers': specialElementHandlers
                            });
                            doc.output('dataurlnewwindow'); 
                        });