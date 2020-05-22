@Override
public ProjectDto getAProject(Long id) {
   Project project = projectRepository.findById(id)
                    .orElseThrow(()->new IllegalArgumentException("Project not found"));

  return modelMapper.map(project, ProjectDto.class);
}