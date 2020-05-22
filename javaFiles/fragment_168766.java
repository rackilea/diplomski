int correct = 0;
int good[] = {1, 2, 3, 4, 5}; // correct answers
int bad[] = {2, 1, 5, 5, 12, 3}; // user guesses

for (int i = 0; i < good.length; i++) {
    for (int j = 0; j < bad.length; j++) {
        if (good[i] == bad[j]) {
            correct++;
            break;
        }
    }
}

System.out.println(correct);