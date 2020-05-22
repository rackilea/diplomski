while (i <= j) {
    if (arr[i] + arr[j] == k) {
        sb.append("{" + arr[i] + "," + arr[j] + "}" + ", ");
        result++;
        i++; // increment
        j--; // decrement
    } else if ((arr[i] + arr[j]) < k) {
        i++;
    } else {
        j--;
    }
}