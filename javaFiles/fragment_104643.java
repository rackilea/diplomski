btn.addEventListener("click", function() {
  fetch(url)
    .then(res => res.json())
    .then(nouns => {
      console.log(nouns);
      var n = nouns.map(noun => {
        return "<tr>" + "<td>" + noun.name + "</td>" + "</tr>";
      });
      tbody.innerHTML = n.join("");
    });
});