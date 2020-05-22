function init() {
  const elem = document.getElementById('eapprox');

  let eapprox = 1;
  const n = 15;
  let frac = 1;

  for (var i = 1; i <= n; ++i) {
    frac /= i;
    eapprox += frac;
  }

  elem.textContent = eapprox;
}