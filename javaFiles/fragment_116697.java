@PutMapping("/exercise/{id}")
public Exercise updateExercise(@RequestBody Exercise newExercise, @PathVariable Long id, @RequestParam Long muscleId) {
    Muscle muscle = muscleRepository.findById(muscleId).orElse(null);
        return repository.findById(id)
                .map(//map a function which maps 
                    e ->{
                    e.setName(newExercise.getName());
                    e.setDescription(newExercise.getDescription());
                    e.setMuscle(muscle);
                    return repository.save(e);
                })
                .orElse(null);
}