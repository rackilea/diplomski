function myFunction() {

    var lista = document.getElementById("listaSeguimientos");  
    var valorLista = lista.options[lista.selectedIndex].value;


    document.body.innerHTML += '<form id="dynForm" action="${pageContext.request.contextPath}/ServletServirReclamos" method="post"><input type="hidden" id="numeroSeguimiento" name="numeroSeguimiento" ></form>';
    document.getElementById("numeroSeguimiento").value = valorLista;
    document.getElementById("dynForm").submit();
    console.log("This is my value " + valorLista);

}