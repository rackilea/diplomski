if (!(question01Answered)) {
    // question01Answered is false and has not been answered. Send them to the first question.
    Intent intent = new Intent(this, Question01.class);
    startActivity(intent);
    finish();
} else if (!(question02Ansered)) {
    // question02Answered is false and has not been answered. Send them to the second question.
    Intent intent = new Intent(this, Question02.class);
    startActivity(intent);
    finish();
} else if (!(question03Answered)) {
   // and so on...
}