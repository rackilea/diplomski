int[] dp; // for minimum steps
bool[] gominus1;
bool[] godivideby2;
bool[] godivideby3;
List<Integer> steps;

PrintAllPath(int n) {
    if(n == 1) {
        // print steps
        return;
    }
    steps.push_back(n);
    if(gominus1[n]) {
        PrintAllPath(n - 1);
    }
    if(godivideby2[n]) {
        PrintAllPath(n / 2);
    }
    if(govidivideby3[n]) {
        PrintAllPath(n / 3);
    }
    steps.pop_back();
}