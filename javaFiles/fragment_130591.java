@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "INGREDIENT_RECIPE_REL",
        joinColumns = {
            @JoinColumn(name = "irr_rcp_id", referencedColumnName = "rcp_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "irr_ing_ingredient", referencedColumnName = "ing_ingredient"),
            @JoinColumn(name = "irr_ing_acc_identifier", referencedColumnName = "ing_acc_identifier")
        })