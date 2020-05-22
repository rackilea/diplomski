function getHint(secret, guess) {
  var bulls = 0;
  var cows = 0;
  var numbers = new Array(10);
  for (var i=0; i<10; i++){
    numbers[i] = 0;
  }
  for (var i = 0; i<secret.length; i++) {
    var s = secret.charCodeAt(i) - 48;
    var g = guess.charCodeAt(i) - 48;
    if (s == g) bulls++;
    else {
      if (numbers[s] < 0) cows++;
      if (numbers[g] > 0) cows++;
      numbers[s] ++;
      numbers[g] --;
    }
  }
  return bulls + "A" + cows + "B";
}

console.log(getHint("1807","7810"));