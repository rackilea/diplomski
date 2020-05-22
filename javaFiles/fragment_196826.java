System.out.println(
    "0=====5====4===3==2=1"
        .replaceFirst("^={1,4}", ":")
);
//  "0=====5====4===3==2=1"

System.out.println(
    "=====5====4===3==2=1"
        .replaceFirst("^={1,4}", ":")
);
//  ":=5====4===3==2=1"

System.out.println(
    "===3==2=1"
        .replaceFirst("^={1,4}", ":")
);
//  ":3==2=1"