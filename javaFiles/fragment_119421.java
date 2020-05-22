@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "QuestionQuestionCategory",
        joinColumns = @JoinColumn(name = "QuestionId", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "QuestionCategoryId", nullable = false)
)
public List<QuestionCategory> getCategories() {
    Hibernate.initialize(categories)
    return categories;
}