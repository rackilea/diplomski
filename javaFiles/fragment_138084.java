import grails.gorm.transactions.Transactional
import grails.web.api.WebAttributes

@Transactional
class MemberService implements WebAttributes {

    def serviceMethod() {
        // you can access params here because 
        // WebAttributes provides access to it
        Member member = new Member(params)

        // ...
    }
}