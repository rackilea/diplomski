$(document).ready(function () {

                    var erros = document.getElementById("erro");
                    if (erros != null) {
                        $([document.documentElement, document.body]).animate({
                            scrollTop: $("#contato").offset().top
                        }, 2000);
                    }


                })