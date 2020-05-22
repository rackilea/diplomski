competenceRepository.findByNameIgnoreCase(postCompetenceDTO.getName())
        .map(c -> new ResponseEntity<Object>("Competence already exist!", HttpStatus.CONFLICT))
        .orElseGet(() -> {
            Competence competence = new Competence();
            competence.setName(postCompetenceDTO.getName());
            return new ResponseEntity<Object>(competence.convertToCompetenceDTO(), HttpStatus.OK);
});