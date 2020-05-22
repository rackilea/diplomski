@OneToMany
    @JoinTable
    (
        name="ingredientslist",
        joinColumns={@JoinColumn(name="recipe_id", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="ingredient_id", referencedColumnName="ID", unique=true)}
    )
    private Set<Ingredient> ingredients;