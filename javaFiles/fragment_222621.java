$.ajax({
url: "Servlet",
type: "POST",
contentType: "application/json; charset=utf-8",
data: JSON.stringify({ "fluxos": fluxos }),
success: function(data) {
    alert("success");
}