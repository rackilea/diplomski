function insertNewHero() {
  var abilities = {};
  $('#newhero .custom-checkbox input:checked').each(function() {
    const $label = $(this).closest("div").find("label");
    abilities[$label.data("id")] = $label.text();
  });

  var superhero = {
    name: "Wanda",
    surname: "Maximoff",
    abilities
  }
  
  console.log(superhero);

  // send data to backend
}

$('#newhero').on("submit", function(e) {
 e.preventDefault();
  insertNewHero();
});