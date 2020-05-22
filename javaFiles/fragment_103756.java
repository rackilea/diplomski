private static final Gson gson = new Gson();

...

final ApplicationError before = new ApplicationError(ErrorCode.INVALID_URL_PARAMETER, "Application identifier is missing");
final String json = gson.toJson(before);
System.out.println(json);
final ApplicationError after = gson.fromJson(json, ApplicationError.class);
System.out.println(before.code == after.code);
System.out.println(before.description.equals(after.description));