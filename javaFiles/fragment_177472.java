@Transactional
def save(User user) {
    if (user == null) {
        transactionStatus.setRollbackOnly()
        render status: NOT_FOUND
        return
    }

    if (user.hasErrors()) {
        transactionStatus.setRollbackOnly()
        render(template: "/errors/errors", model: [errors: user.errors])
        return
    }

    user.save flush:true

    respond user, [status: CREATED, view:"show"]
}