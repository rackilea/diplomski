Builder builder = new FormBody.Builder();
String[] names = { "task", "status", "reoccurring", "spent_time", "impediments" };
for (String name : names) {
    Object value = task.get(name);
    if (value != null)
        builder.add(name, value instanceof String ? (String) value : String.valueOf(value));
}

FormBody formBody = builder.build();