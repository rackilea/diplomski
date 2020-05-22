GroovyRequestFixture.handle(sessionChain) {
    uri 'foo'
    method 'GET'
    registry { r ->
        r.add(Session, session)
    }
}