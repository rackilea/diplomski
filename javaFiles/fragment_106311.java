//You probably should rename the developer variable to "result".
Optional<Developer> developer = repository.findById(id);
if(developer.isPresent()){
    //developer found, you can get it.
    Developer aDeveloper = developer.get();
    //aDeveloper.hasSkill(skill); is acessible now.
}else{
    //no developer found with the specified Id.
}