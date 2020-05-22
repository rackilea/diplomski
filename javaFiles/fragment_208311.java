class userService {

    void userComment(uName)
    {  
        def uCat = Category.getUserCategory(uName)

        if (uCat.empty){    
            println("no categories to process")
        }
        else
        {
            postComment(uName)
            batchJob.sendEmail(uName)   
        }
    }
}


class userServiceSpec extends Specification{
    def userService = Spy(userService)
    def CategorySpy = GroovySpy(Category, global: true)

    def "test userComment"()
    {   
        given:
        def uName = "test123"  

        when: 'we have a category found'  
        userService.userComment(uName)

        then: 'return user cat of "seller" '
        1 * CategorySpy.getUserCategory(uName) >> 'seller'
        1 * postComment(uName)

        then:
        1 * batchJob.sendEmail(uName)

        when: 'we have an "empty" category'  
        userService.userComment(uName)

        then: 'return a category where uCat.empty will be true'
        1 * CategorySpy.getUserCategory(uName) >> []
        0 * postComment(uName)
        0 * batchJob.sendEmail(uName)
    }
}