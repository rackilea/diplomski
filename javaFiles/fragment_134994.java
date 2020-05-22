class User {
    String email

    static mapping = {
        datasource 'system'
    }

    static constraints = {
        email nullable: false
    }
}