package org.example.project.domain;

@Entity
class Classifier {
  @ManyToOne
  private ClassifierGroup group;

  public ClassifierGroup getGroup() { return group; }

  // Package protected to prevent direct access.
  void setGroup(ClassifierGroup group) { this.group = group; }
}

@Entity
class ClassifierGroup {
  @OneToMany
  private List<Classifier> classifiers;

  public void addClassifier(Classifier classifier) {
    if(classifiers == null) {
      classifiers = new ArrayList<Classifier>();
    }

    classifiers.add(classifier);
    classifier.setGroup(this);
  }

  public List<Classifier> getClassifiers() {
    return Collections.unmodifiableList(classifiers != null ? classifiers : Collections.emptyList());
  }
}

ClassifierGroup group = new ClassifierGroup();
group.addClassifier(new Classifier());
manager.saveClassifierGroup(group);