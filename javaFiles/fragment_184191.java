$(function() {

    $.ajax({
        url : rutaBase + '/huecos.json',
        success : function(huecos) {
            var enabledDates = [];
            for ( var key in huecos) {
                if (huecos.hasOwnProperty(key)) {
                    enabledDates.push(key);
                }
            }

            $('#fechaCita').datetimepicker({
                format : 'DD/MM/YYYY', // Solo se mostrará la fecha
                enabledDates : enabledDates,
                icons : {
                    date : "fa fa-calendar",
                    up : "fa fa-caret-up",
                    down : "fa fa-caret-down",
                    previous : "fa fa-caret-left",
                    next : "fa fa-caret-right",
                    today : "fa fa-today",
                    clear : "fa fa-clear",
                    close : "fa fa-close"
                }

            });

            $("#fechaCita").on(
                    "change.datetimepicker",
                    function(e) {
                        $('#selectHoraCita').empty();
                        $('#selectHoraCita').append($("<option></option>").attr("value","").text("--"));
                        var horas = [];
                        var fecha = moment(e.date).format('YYYY-MM-DD');
                        horas.push(huecos[fecha]);
                        horas
                                .forEach(function(listItem) {

                                    listItem.forEach(function(opcion) {
                                        $('#selectHoraCita').append(
                                                $("<option></option>").attr(
                                                "value", opcion).text(
                                                opcion));
                                    });
                                });
                    });

        },
        error : function() {
            console.log('Error');
        }

    });

});