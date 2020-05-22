String test = "A~B~C~~D~E";
System.out.println(
    Arrays.toString(
        test.split("(?<!~)~(?!~)")
    )
);