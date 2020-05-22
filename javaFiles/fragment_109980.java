String str = "input";
int mid = -1;

if(str.length() % 2 == 0) {
    str.length() / 2 - 1 
} else {
    str.length() / 2;
}

char[] arr = str.toCharArray();
char temp = '0';
temp = arr[0];
arr[0] = arr[mid];
arr[mid] = temp;

String.valueOf(arr);