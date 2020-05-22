public void addSkillToUser(Long s) {
    Skill skill = skillRepository.findOne(s);
    selectedUser.addSkill(skill);
    skill.addSkillOwner(selectedUser);
    userRepository.save(selectedUser);
    skillRepository.save(skill);
}