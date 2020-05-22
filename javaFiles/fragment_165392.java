@Modifying
@Transactional
@Query(value = "DELETE FROM collaborators_competences WHERE (collaborator_id, competence_id)\n" +
    "                                                IN (SELECT collaborator_id, competence_id FROM collaborators_competences\n" +
    "                                                    JOIN collaborators c on collaborators_competences.collaborator_id = c.id\n" +
    "                                                JOIN competences c2 on collaborators_competences.competence_id = c2.id\n" +
    "                                                WHERE c.id = (SELECT collaborators.id FROM collaborators WHERE login = :collabLogin) AND c2.id = :competenceId)", nativeQuery = true)
void deleteByCollaboratorLoginAndCompetenceId(@Param("collabLogin") String login, @Param("competenceId") Long id);




@Transactional
void deleteCollaboratorCompetenceById(CollaboratorCompetenceId id);