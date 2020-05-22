class ValidatorUniqueLogin : ConstraintValidator<UniqueLogin, String> {

    @Autowired val serviceAccaunt: ServiceAccaunt? = null

    override fun initialize(annotation: UniqueLogin?) {}

    override fun isValid(login: String, ctx: ConstraintValidatorContext): Boolean {
        return if (serviceAccaunt!= null) !(serviceAccaunt.isHaveLogin(login)) else true
    }
}