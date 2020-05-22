Path<Object> path = r.get("acceptorId");
CriteriaBuilder.In<Object> in = builder.in(path);
for (String oneId: idStringList) {
    in.value(oneId);
}
predicate = builder.and(predicate, in);