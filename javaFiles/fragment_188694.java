StringBuilder bld = new StringBuilder();

for (int arr_i = 0; arr_i < n; arr_i++) {
    int i = in.nextInt();
    bld.insert(0, i);
}

System.out.println(bld.toString());