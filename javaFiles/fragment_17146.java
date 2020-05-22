String[] tests = { "11101100112021120", "222222222", "222222122",
        "000000000", "0000100000", "11121222212112133321" };

for (String data : tests) {
    System.out.println(data + " ->" + Arrays.toString(data.split("0+|(?<=([1-9]))(?=[1-9])(?!\\1)")));
    System.out.println("-----------------------");
}