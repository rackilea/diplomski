String json = "...";

Gson gson = new Gson();

Data data = gson.fromJson(json, Data.class);

data.args.forEach((key, value) -> {
    System.out.println(key);
    System.out.println(value.expectCliArgs);
    System.out.println(value.expectedNumberOfCliArgs);
    System.out.println(value.expectedErrorMessage);
    System.out.println();
});