@Entity
@AttributeOverride(name="nrCompte", column=@Column(unique=false))
public class CompteTmp extends AbstractCompte { ... }

@Entity
@AttributeOverride(name="nrCompte", column=@Column(unique=true))
public class Compte extends AbstractCompte { ... }