@Given("I see given step")
    public void given()
    {
        System.out.println("Inside GIVEN");
    }

    @When("I see when step")
    public void then()
    {
        System.out.println("Inside THEN");
    }

    @Then("I see then step")
    public void when()
    {
        System.out.println("Inside WHEN");
    }

    @Then("your step executed last")
    public void then()
    {
        // logic from composite()
        System.out.println("Inside COMPOSITE");
    }

    @Given("I see composite step")
    @Composite(steps={"Given I see given step","When I see when step","Then I see then step","Then your step executed last"})
    public void composite()
    {
         //logic got moved
    }