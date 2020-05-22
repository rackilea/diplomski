public void deleteSkill(Skill skill) {
    selectedUser.deleteSkill(skill);
    skill.removeSkillOwner(selectedUser);
    skillRepository.save(skill);
    userRepository.save(selectedUser);
}