function calculateGrades(number) {
  var letterGrade = "F";
  if (number <= 59)
    letterGrade = "F";
  else if (number >= 60 && number <= 66)
    letterGrade = "D";
  else if (number >= 67 && number <= 69)
    letterGrade = "D+";
  else if (number >= 70 && number <= 76)
    letterGrade = "C";
  else if (number >= 77 && number <= 79)
    letterGrade = "C+";
  else if (number >= 80 && number <= 86)
    letterGrade = "B";
  else if (number >= 87 && number <= 89)
    letterGrade = "B+";
  else if (number >= 90 && number <= 100)
    letterGrade = "A";
  return letterGrade;
}

function grade() {
  var test1 = parseFloat(document.getElementById('test').value * 0.20);
  var test2 = parseFloat(document.getElementById('test3').value * 0.20);
  var finalexam = parseFloat(document.getElementById('exam').value * 0.30);
  var labs = parseFloat(document.getElementById('labs').value * 0.25);
  var project = parseFloat(document.getElementById('project').value * 0.25);
  var quizzes = parseFloat(document.getElementById('quiz').value * 0.5);
  var total = test1 + test2 + finalexam + labs + project + quizzes;
  return total;
}

function showGrades() {
  var number = grade();
  var letter = calculateGrades(number);
  document.getElementById('numbergrade').value = number;
  document.getElementById('lettergrade').value = letter;
}