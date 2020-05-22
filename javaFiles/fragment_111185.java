class EnumDslJvmModelInferrer extends AbstractModelInferrer {

    @Inject extension JvmTypesBuilder
    def dispatch void infer(EnumModel element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
        element.pckg.enums.forEach[ myEnum |
            acceptor.accept(myEnum.toEnumerationType(element.pckg.name+"."+myEnum.name)[]).initializeLater[
                myEnum.items.forEach [ literal |
                    it.members += myEnum.toEnumerationLiteral(literal)
                ]
            ]
        ]
    }
}