// 1. raw type
@SuppressWarnings("unchecked")
List<List<?>> list0 = (List) api();

// 2. slightly safer
@SuppressWarnings({"unchecked", "rawtypes"})
List<List<?>> list1 = (List<List<?>>) (List<? extends List>) api();

// 3. avoids a raw type warning
@SuppressWarnings("unchecked")
List<List<?>> list2 = (List<List<?>>) (List<? super List<?>>) api();