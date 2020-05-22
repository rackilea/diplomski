import cucumber.api.java8.En;

public class stepDefinitions implements En{

public stepDefinitions(){
    Given("^User is on Home Page$", () -> {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test1");
    });

    When("^User enters UserName and Password$", () -> {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test2");
    });

    Then("^He can visit the practice page$", () -> {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test3");
    });

    When("^User LogOut from the Application$", () -> {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test4");
    });

    Then("^he cannot visit practice page$", () -> {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Test5");
    });
   }
 }