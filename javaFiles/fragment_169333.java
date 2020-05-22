@Autowired
private DisciplineRepository disciplineRepository; 

@RequestMapping(value = "/disciplines/{id}/changes", method = RequestMethod.GET)
public ResponseEntity<Resource<RevisionsObject>> getDisciplineRevisions(@PathVariable(value = "id")Discipline discipline) {
    if (discipline != null) {
        Revisions<Integer, Discipline> disciplineRevisions = disciplineRepository.findRevisions(discipline.getId());
        return new ResponseEntity<>(new Resource<>(disciplineRevisions), HttpStatus.OK);
    } else {
        throw new ResourceNotFoundException();
    }
}