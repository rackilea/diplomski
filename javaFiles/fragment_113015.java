function toast(status){
    const inputVal = document.getElementById("myInput").value;

    const container = document.getElementById("toastcontainer");

    const toastdiv = document.createElement("div");

    const toastColor = (status == 'error' ? 'red' : (status == 'success' ? 'green' : (status == 'info' ? 'blue' : '')));

    toastdiv.style.backgroundColor = toastColor;

    toastdiv.innerHTML = inputVal;
    container.appendChild(toastdiv);
}