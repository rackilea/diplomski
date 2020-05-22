str.append(s.charAt(k));
if (flag) {
    k += step2;
    flag = false;
} else {
    k += step3;
    flag = true;
}