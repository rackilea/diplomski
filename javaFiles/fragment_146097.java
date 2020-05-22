$.ajax({
    type: "POST",
    url: document.getElementById("urltxt").value,
    data: parameters,
    complete: function() {
        window.location.replace(...);
      }
  });