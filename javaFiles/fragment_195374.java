int start = 0;
int middle = 0;
int end = 0;
int sum = 0;
...
if (code2 > code) {
    start = Days[code] - inputDay + 1;
    for (int count = inputMonth; count < code2; count++) {
        middle += Days[count];
    }
    end = inputDay2;
} else {
    start = inputDay2 - inputDay + 1;
}

sum = start + middle + end;