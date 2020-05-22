String arr[][] = {
    {"Jerry",  "s" },
    {"Jerry1", "s1"},
    {"Oya",    "e" }
};

String app1 = "Oya";

for (int i = 0; i < arr.length; i++) {
    if (app1.equals(arr[i][0])) {
        return arr[i][1];
    }
}