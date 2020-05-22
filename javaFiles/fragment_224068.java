boolean isFirstDone = false;
for(String oneId: idStringList){
    if(!isFirstDone) {
        predicate = builder.and(predicate, builder.equal(r.get("acceptorId"), oneId));
        isFirstDone = true;
    }
    else{
        predicate = builder.or(predicate, builder.equal(r.get("acceptorId"), oneId));
    }
}